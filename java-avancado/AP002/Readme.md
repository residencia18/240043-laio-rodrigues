# API de Gerenciamento de Usuários

Esta API permite que os usuários se registrem, façam login, solicitem a recuperação de senha e redefinam suas senhas. Ela oferece endpoints simples e seguros para operações de autenticação e gerenciamento de contas de usuário.

## Endpoints Disponíveis

### Registro de Usuário

Endpoint:
```
POST /api/auth/register
```

Este endpoint permite que os usuários se registrem na aplicação fornecendo um nome de usuário, um endereço de e-mail e uma senha.

Payload de Requisição (JSON):
```json
{
  "username": "example",
  "email": "user@example.com",
  "password": "password"
}
```

Resposta de Sucesso (200 OK):
```json
{
  "message": "User registered successfully!"
}
```

### Login de Usuário

Endpoint:
```
POST /api/auth/login
```

Este endpoint permite que os usuários façam login na aplicação fornecendo seu nome de usuário e senha.

Payload de Requisição (JSON):
```json
{
  "username": "example",
  "password": "password"
}
```

Resposta de Sucesso (200 OK):
```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c"
}
```

### Solicitação de Recuperação de Senha

Endpoint:
```
POST /api/password-recovery
```

Este endpoint permite que os usuários solicitem a recuperação de senha fornecendo seu endereço de e-mail.

Payload de Requisição (JSON):
```json
{
  "email": "user@example.com"
}
```

Resposta de Sucesso (200 OK):
```json
{
  "message": "Email sent successfully!"
}
```

### Redefinição de Senha

Endpoint:
```
POST /api/password-reset
```

Este endpoint permite que os usuários redefinam sua senha fornecendo um token de recuperação e uma nova senha.

Payload de Requisição (JSON):
```json
{
  "token": "validToken",
  "newPassword": "newPassword"
}
```

Resposta de Sucesso (200 OK):
```json
"Password reset successfully!"
```

## Documentação da API

Para obter mais detalhes sobre os modelos de dados e os endpoints disponíveis, consulte a documentação da API em [http://localhost:8080/swagger-ui/](http://localhost:8080/swagger-ui/).
