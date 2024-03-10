import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrl: './header.component.css',
})
export class HeaderComponent {
  @Input() isLogado: boolean = false;
  @Output() login = new EventEmitter<string>();
  @Output() logout = new EventEmitter<string>();
  @Output() signup = new EventEmitter<string>();

  onLogout() {
    this.logout.emit('logout');
  }

  onLogin() {
    this.login.emit('login');
  }

  onSignUp() {
    this.signup.emit('signup');
  }
}
