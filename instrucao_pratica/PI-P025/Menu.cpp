#include"Menu.hpp"


void Menu::limpaTela(){
    #ifdef _WIN32
        system("cls");
    #elif linux
        system("clear");
    #endif
}

void Menu::limpaBuffer(){
    while (cin.get() != '\n') {
        continue;
    }
}

void Menu::pausaTela(){
    cout << "Pressione Enter para continuar...";
    cin.get();
}


int Menu::dispMain(){
    int op;
    limpaTela();
    cout << "*************** XWITTER ***************" << endl << endl;
    cout << "1 - Fazer Login" << endl;
    cout << "2 - Registre-se" << endl;
    cout << "0 - Fechar" << endl << endl;
    cout << "*************** XWITTER ***************" << endl << endl;
    cout << "Opcao: ";
    cin >> op;
    limpaBuffer();
    return op;
}

void Menu::dispLogin(string* _username, string* _password){
    limpaTela();
    cout << "*************** XWITTER ***************" << endl;
    cout << "**************** LOGIN ****************" << endl << endl;
    cout << "Digite seu nome de usuario" << endl << ">";
    getline(cin, *_username);
    cout << "Digite sua senha" << endl << ">";
    getline(cin, *_password);
    cout << endl;
    cout << "*************** XWITTER ***************" << endl << endl;
}

void Menu::dispRegister(string* _nome, string* _username, string* _password){
    limpaTela();
    cout << "*************** XWITTER ***************" << endl;
    cout << "************* REGISTRAR-SE ************" << endl << endl;
    cout << "Digite seu nome" << endl << ">";
    getline(cin, *_nome);
    cout << "Digite seu nome de usuario" << endl << ">";
    getline(cin, *_username);
    cout << "Digite sua senha" << endl << ">";
    getline(cin, *_password);
    cout << endl;
    cout << "*************** XWITTER ***************" << endl << endl;
}

void Menu::dispLogout(){
    limpaTela();
    cout << "*************** XWITTER ***************" << endl;
    cout << "**************** LOGOUT ****************" << endl << endl;
    cout << "Sessao finalizada, faca logn novamente" << endl << endl;
    cout << "*************** XWITTER ***************" << endl << endl;
    pausaTela();
}


int Menu::dispHome(string _username, string _nome, int _qtdSd, int _qtdSn){
    int op;
    limpaTela();
    cout << "*************** XWITTER ***************" << endl;
    cout << "***************  HOME   ***************" << endl << endl;
    dispSeguidores(_username, _nome, _qtdSd, _qtdSn);
    cout << "1 - Ver Feed" << endl;
    cout << "2 - Novo Tweet" << endl;
    cout << "3 - Pesquisar" << endl;
    cout << "4 - Ver Seguidores" << endl;
    cout << "5 - Excluir Sua Conta" << endl;
    cout << "0 - Encerrar Sessao" << endl << endl;
    cout << "*************** XWITTER ***************" << endl << endl;
    cout << "Opcao: ";
    cin >> op;
    limpaBuffer();
    return op;
}

void Menu::dispFeed(string _username, string _conteudo, string _dt){
    cout << "+---------------+---------------+" << endl
         << "| " <<_dt << "\t|  " << _username << "\t|" << endl
         << "+---------------+---------------+" << endl
         << _conteudo << endl
         << "+---------------+---------------+" << endl << endl;
}

void Menu::dispTweet(string* _conteudo){
    limpaTela();
    cout << "*************** XWITTER ***************" << endl;
    cout << "************** NOVO TWEET *************" << endl << endl;

    cout << "+------------------+-------------------+" << endl
         << "|    O que voce esta pensando hoje?    |" << endl
         << "+------------------+-------------------+" << endl;
    cout << endl;
    cout << ">";
    getline(cin, *_conteudo);
    cout << endl;
    cout << "*************** XWITTER ***************" << endl << endl;
    pausaTela();
}

void Menu::dispPesquisa(string* _pesquisa){
    limpaTela();
    cout << "*************** XWITTER ***************" << endl;
    cout << "************** PESQUISAR **************" << endl << endl;
    cout << "Digite um nome de usuario" << endl << ">";
    getline(cin, *_pesquisa);
    cout << endl;
    cout << "*************** XWITTER ***************" << endl << endl;
}

int Menu::dispUsuario(string _username, string _nome, int _qtdSd, int _qtdSn, bool _segue){
    int op;
    limpaTela();
    cout << "*************** XWITTER ***************" << endl;
    cout << "**************  USUARIO  **************" << endl << endl;
    dispSeguidores(_username, _nome, _qtdSd, _qtdSn);
    if(_segue)
        cout << "1 - Deixar de Seguir" << endl;
    else
        cout << "1 - Seguir" << endl;
    cout << "2 - Ver Tweets" << endl;
    cout << "3 - Ver Seguidores" << endl;
    cout << "0 - Voltar" << endl << endl;
    cout << "*************** XWITTER ***************" << endl << endl;
    cout << "Opcao: ";
    cin >> op;
    limpaBuffer();
    return op;
}

void Menu::dispSeguidores(string _username, string _nome, int _qtdSd, int _qtdSn){
    cout << "+---------------+---------------+" << endl
         << "| " <<_username << "\t|  " << _nome << "\t|" << endl
         << "+---------------+---------------+" << endl
         << "| " << _qtdSd << " seguidores\t|  " << _qtdSn << " seguindo \t|" << endl
         << "+---------------+---------------+" << endl << endl;
}

int Menu::dispExcluir(){
    limpaTela();
    cout << "*************** XWITTER ***************" << endl;
    cout << "*************** EXCLUIR ***************" << endl << endl;
    cout << "Tem certeza que quer excluir sua conta?" << endl << endl;
    cout << "1 - Sim" << endl;
    cout << "2 - Nao" << endl << endl;
    cout << "Opcao: ";
    int op;
    cin >> op;
    limpaBuffer();
    return op;
}

void Menu::dispConfirma(string* _password){
    limpaTela();
    cout << "*************** XWITTER ***************" << endl;
    cout << "************** CONFIRMAR **************" << endl << endl;
    cout << "Digite sua senha" << endl << ">";
    getline(cin, *_password);
    cout << endl;
    cout << "*************** XWITTER ***************" << endl << endl;
}


void Menu::success(string msg){
    limpaTela();
    cout << "*************** XWITTER ***************" << endl;
    cout << "********* SUCESSO NA OPERACAO *********" << endl << endl;
    cout << msg << endl << endl;
    cout << "*************** XWITTER ***************" << endl;
    pausaTela();
}

void Menu::error(string msg){
    limpaTela();
    cout << "*************** XWITTER ***************" << endl;
    cout << "********* ERRO NA OPERACAO *********" << endl << endl;
    cout << msg << endl << endl;
    cout << "*************** XWITTER ***************" << endl;
    pausaTela();
}