import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { AutenticaService } from './services/autentica.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
})
export class AppComponent {
  title = 'PetShop';
  logado: boolean = false;
  logInSubscribtion: Subscription;

  constructor(private router: Router, private autenticaService: AutenticaService) {
    this.logInSubscribtion = this.autenticaService.loggedIn.subscribe({
      next: (value: boolean) => {
        this.logado = value;
        console.log('logged: ', this.logado);
      },
    });
  }

  ngOnInit() {
    this.logado = this.autenticaService.isLogged();
  }

  onLogin(event: string) {
    this.router.navigate(['/login']);
  }

  onLogout(event: string) {
    this.autenticaService.logout();
    this.logado = false;
    this.router.navigate(['/login']);
  }

  onSignUp(event: string) {
    this.router.navigate(['/signup']);
  }
}
