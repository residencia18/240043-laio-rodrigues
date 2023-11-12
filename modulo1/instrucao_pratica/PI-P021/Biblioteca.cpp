#include"Biblioteca.hpp"

void Biblioteca::init(){
    int op;

    abrirArqUser();
    abrirArqLivros();
    abrirArqEmprestimo();
    
    do{
        op = Menu::dispMain();
        switch (op){
            case 1:
                emprestimo();
                break;
            case 2:
                pesquisa();
                break;
            case 3:
                devolucao();
                break;
            case 4:
                menuLivro();
                break;
            case 5:
                menuUser();
                break;
            case 0:
                salvarArqUser();
                salvarArqLivros();
                salvarArqEmprestimo();
                break;
            default:
                break;
        }
    } while (op != 0);
}

void Biblioteca::abrirArqUser(){
    ifstream is("usuarios.txt");

    if (!is.is_open()){
        cout << "Erro ao abrir arquivo usuarios.txt" << endl;
        exit(1);
    }
    
    string linha;
    
    while (getline(is, linha)){
        istringstream ss(linha);
        string id, nome, email, senha;

        if( getline(ss, id, ',' ) && getline(ss, nome, ',') && 
            getline(ss, email, ',') && getline(ss, senha, ',')){
            Usuario* novo = new Usuario();
            novo->setId(id);
            novo->setNome(nome);
            novo->setEmail(email);
            novo->setSenha(senha);
            novo->setCont(stoi(id));
            usuarios.push_back(novo);
        }
    }

    is.close();
}

void Biblioteca::abrirArqLivros(){
    ifstream is("livros.txt");
    
    if (!is.is_open()){
        cout << "Erro ao abrir arquivo livros.txt" << endl;
        exit(1);
    }
    
    string linha;
    
    while (getline(is, linha)){
        istringstream ss(linha);
        string id, titulo, autor, s_copias, s_totais;
        
        if( getline(ss, id, ',') && getline(ss, titulo, ',') && 
            getline(ss, autor, ',') && getline(ss, s_copias, ',') && getline(ss, s_totais)){
                Livro* novo = new Livro();
                novo->setId(id);
                novo->setTitulo(titulo);
                novo->setAutor(autor);
                novo->setCopias(stoi(s_copias));
                novo->setCopiasTotais(stoi(s_totais));
                novo->setCont(stoi(id));
                livros.push_back(novo);
            }
    }
    
    is.close();
}

void Biblioteca::abrirArqEmprestimo(){
    ifstream is("emprestimos.txt");
    
    if (!is.is_open()){
        cout << "Erro ao abrir arquivo emprestimos.txt" << endl;
        exit(1);
    }
    
    string linha;
    
    while (getline(is, linha)){
        istringstream ss(linha);
        string id, id_livro, id_usuario, status, dt_retirada, dt_devolucao;
        
        getline(ss, id, ',');
        getline(ss, id_livro, ',');
        getline(ss, id_usuario, ',');
        getline(ss, status, ',');
        getline(ss, dt_retirada, ',');
        getline(ss, dt_devolucao, ',');
            
        Emprestimo* novo = new Emprestimo();
        novo->setId(id);

        int idx = getIdxLivroById(id_livro);
        if(idx < 0){
            Menu::errorNFlivro();
            return;
        }

        novo->setLivro(getLivro(idx));

        idx = getIdxUsuarioById(id_usuario);
        if(idx < 0){
            Menu::errorNFuser();
            return;
        }

        novo->setUsuario(getUsuario(idx));
        novo->setStatus(status);
        
        istringstream dt(dt_retirada);
        string dia, mes, ano;
        if(getline(dt, dia, '/') && getline(dt, mes, '/') && getline(dt, ano, '/')){
            Data* nova_ret = new Data(stoi(dia), stoi(mes), stoi(ano));
            novo->setDt_retirada(nova_ret);
        }

        istringstream dt2(dt_devolucao);
        string dia2, mes2, ano2;
        if(getline(dt2, dia2, '/') && getline(dt2, mes2, '/') && getline(dt2, ano2, '/')){
            Data* nova_dev = new Data(stoi(dia2), stoi(mes2), stoi(ano2));
            
            Data* hoje = Data::getDataAtual();
            if(hoje->diaEntre(nova_dev) < 0){
                novo->setStatus("ATRASADO");
            }
            novo->setDt_devolucao(nova_dev);
        }

        emprestimos.push_back(novo);
    }
    
    is.close();
}


void Biblioteca::salvarArqUser(){
    ofstream os("usuarios.txt");
    
    if (!os.is_open()){
        cout << "Erro ao abrir arquivo usuarios.txt" << endl;
        exit(1);
    }
    
    for(int i = 0; i < usuarios.size(); i++){
        os << usuarios[i]->getId() << ',';
        os << usuarios[i]->getNome() << ',';
        os << usuarios[i]->getEmail() << ',';
        os << usuarios[i]->getSenha() << ',';
        os << endl;
    }
    
    os.close();
}

void Biblioteca::salvarArqLivros(){
    ofstream os("livros.txt");
    
    if (!os.is_open()){
        cout << "Erro ao abrir arquivo livros.txt" << endl;
        exit(1);
    }
    
    for(int i = 0; i < livros.size(); i++){
        os << livros[i]->getId() << ',';
        os << livros[i]->getTitulo() << ',';
        os << livros[i]->getAutor() << ',';
        os << livros[i]->getCopias() << ',';
        os << livros[i]->getCopiasTotais() << ',';
        os << endl;
    }
    
    os.close();
}

void Biblioteca::salvarArqEmprestimo(){
    ofstream os("emprestimos.txt");

    if (!os.is_open()){
        cout << "Erro ao abrir arquivo emprestimos.txt" << endl;
        exit(1);
    }

    for(int i = 0; i < emprestimos.size(); i++){
        os << emprestimos[i]->getId() << ',';
        os << emprestimos[i]->getLivro()->getId() << ',';
        os << emprestimos[i]->getUsuario()->getId() << ',';
        os << emprestimos[i]->getStatus() << ',';
        os << emprestimos[i]->getDt_retirada()->toString() << ',';
        os << emprestimos[i]->getDt_devolucao()->toString() << ',';
        os << endl;
    }

    os.close();
}


Livro* Biblioteca::getLivroByNome(){
    int idx;
    string t1, t2;

    Menu::dispGetNomeLivro(&t1, &t2);

    idx = getIdxLivroByNome(t1, t2);

    if(idx < 0){
        Menu::errorNFlivro();
        return NULL;
    }

    return getLivro(idx);
}

Livro* Biblioteca::getLivroById(){
    int idx;
    string id;

    Menu::dispGetIdLivro(&id);

    idx = getIdxLivroById(id);

    if(idx < 0){
        Menu::errorNFlivro();
        return NULL;
    }

    return getLivro(idx);
}

Usuario* Biblioteca::getUserById(){
    int idx;
    string id;

    Menu::dispGetIdUser(&id);

    idx = getIdxUsuarioById(id);

    if(idx < 0){
        Menu::errorNFuser();
        return NULL;
    }

    return getUsuario(idx);
}

Usuario* Biblioteca::getUsuarioByNome(){
    int idx;
    string nome, email;

    Menu::dispGetNomeUser(&nome);
    Menu::dispGetEmailUser(&email);

    idx = getIdxUsuarioByNome(nome, email);

    if(idx < 0){
        Menu::errorNFuser();
        return NULL;
    }

    return getUsuario(idx);
}

bool Biblioteca::autentica(Usuario* usuario){
    string senha;

    Menu::dispGetSenhaUser(&senha);

    return usuario->autentica(senha);
}


void Biblioteca::emprestimo(){
    Livro* livro;
    Usuario* usuario;
    int tempo = 7, k = 0;
    string status = "Emprestado";

    livro = getLivroById();
    if(livro == NULL){
        return;
    }

    if(livro->getCopias() == 0){
        Menu::errorNFcopias();
        return;
    }

    usuario = getUserById();
    if(usuario == NULL){
        return;
    }

    Data* dt_retirada = Data::getDataAtual();

    do{
        if(autentica(usuario)){
            Emprestimo* novo = new Emprestimo(livro, usuario, status, dt_retirada, tempo);
            livro->setCopias(livro->getCopias() - 1);
            addEmprestimo(novo);
            k = 10;
            Menu::success("Emprestimo realizado com sucesso!");
        }else{
            k++;
            Menu::errorAutenticacao();
        }
    } while (k < 3);
    if(k < 5){
        Menu::errorLimite();
    }
}

void Biblioteca::pesquisa(){
    Livro* livro = getLivroByNome();
    if(livro == NULL){
        return;
    }
    cout << livro->dispToString() << endl;
    cout << livro->toString();
    Menu::pausaTela();
}

void Biblioteca::devolucao(){
    Usuario* usuario = getUserById();
    
    if(usuario == NULL){
        return;
    }
    
    Livro* livro = getLivroById();

    if(livro == NULL){
        return;
    }

    for(Emprestimo* e : emprestimos){
        if(e->getUsuario()->getId() == usuario->getId() && e->getLivro()->getId() == livro->getId()){
            if(e->getStatus().compare("Emprestado") == 0){
                e->setStatus("Devolvido");
                livro->setCopias(livro->getCopias() + 1);
                Menu::success("Devolução realizada com sucesso!");
            }else if(e->getStatus().compare("ATRASADO") == 0){
                e->setStatus("Devolvido com atraso");
                livro->setCopias(livro->getCopias() + 1);
                Menu::success("Devolução realizada com sucesso!");
            }else {
                Menu::errorNFdevolucao();
            }
        }
    }

}


void Biblioteca::menuLivro(){
    int op;
    
    do{
        op = Menu::dispMenuLivro();
        switch (op){
            case 1:
                novoLivro();
                break;
            case 2:
                rmLivro();
                break;
            case 3:
                alterarEstoque();
                break;
            case 4:
                listarTodosLivros();
                break;
            case 5:
                listarLivrosUsuario();
                break;
            default:
                break;
        }
    } while (op != 0);
}

void Biblioteca::novoLivro(){
    string t1, t2;
    int copias;

    Menu::dispGetNomeLivro(&t1, &t2);
    Menu::dispGetCopiasLivro(&copias);

    if(getIdxLivroByNome(t1, t2) >= 0){
        Menu::errorLivroExiste();
        return;
    }

    Livro* livro = new Livro(t1, t2, copias);
    addLivro(livro);

    Menu::success("Livro cadastrado com sucesso!");
}

void Biblioteca::rmLivro(){
    string id;
    
    Menu::dispGetIdLivro(&id);
    int idx = getIdxLivroById(id);
    
    if(idx < 0){
        Menu::errorNFlivro();
        return;
    }
    
    if(livros[idx]->getCopias() != livros[idx]->getCopiasTotais()){
        Menu::errorEmpCopias();
        return;
    }

    removeLivro(idx);
    Menu::success("Livro removido com sucesso!");
}

void Biblioteca::alterarEstoque(){
    string id;
    int copias;

    Menu::dispGetIdLivro(&id);

    int idx = getIdxLivroById(id);

    if(idx < 0){
        Menu::errorNFlivro();
        return;
    }

    Menu::dispGetCopiasLivro(&copias);

    livros[idx]->setCopiasTotais(livros[idx]->getCopiasTotais()+copias);
    livros[idx]->setCopias(livros[idx]->getCopias()+copias);

    Menu::success("Estoque alterado com sucesso!");
}

void Biblioteca::listarTodosLivros(){
    Menu::limpaTela();
    cout << Livro::dispToString() << endl;
    for(size_t i = 0; i < livros.size(); i++){
        cout << livros[i]->toString() << endl;
    }
    Menu::pausaTela();
}

void Biblioteca::listarLivrosUsuario(){
    string id;

    Menu::dispGetIdUser(&id);
    int idx = getIdxUsuarioById(id);
    
    if(idx < 0){
        Menu::errorNFuser();
        return;
    }
    
    Menu::limpaTela();
    string stts, dev;
    cout << Livro::dispToStringEmp() << endl;
    
    for(int i = 0; i < emprestimos.size(); i++){
        if(emprestimos[i]->getUsuario()->getId() == id){
            stts = emprestimos[i]->getStatus();
            dev = emprestimos[i]->getDt_devolucao()->toString();
            cout << emprestimos[i]->getLivro()->toStringEmp(stts, dev) << endl;
        }
    }

    Menu::pausaTela();
}


void Biblioteca::menuUser(){
    int op;
    
    do{
        op = Menu::dispMenuUser();
        switch (op){
            case 1:
                novoUser();
                break;
            case 2:
                rmUser();
                break;
            case 3:
                alterarEmail();
                break;
            case 4:
                alterarSenha();
                break;
            case 5:
                listarUsuarios();
                break;
            default:
                break;
        }
    } while (op!= 0);
}

void Biblioteca::novoUser(){
    string nome, email, senha;
    
    Menu::dispGetNomeUser(&nome);
    Menu::dispGetEmailUser(&email);
    Menu::dispGetSenhaUser(&senha);
    
    if(getIdxUsuarioByNome(nome, email) >= 0){
        Menu::errorUserExiste();
        return;
    }
    
    Usuario* usuario = new Usuario(nome, email, senha);
    addUsuario(usuario);

    Menu::success("Usuario cadastrado com sucesso!");
}

void Biblioteca::rmUser(){
    string id;
    
    Menu::dispGetIdUser(&id);
    int idx = getIdxUsuarioById(id);
    
    if(idx < 0){
        Menu::errorNFuser();
        return;
    }
    
    removerUsuario(idx);

    Menu::success("Usuario removido com sucesso!");
}

void Biblioteca::alterarEmail(){
    string id;
    string email;

    Menu::dispGetIdUser(&id);
    int idx = getIdxUsuarioById(id);
    
    if(idx < 0){
        Menu::errorNFuser();
        return;
    }
    
    Menu::dispGetEmailUser(&email);
    
    usuarios[idx]->setEmail(email);
    
    Menu::success("E-mail alterado com sucesso!");
}

void Biblioteca::alterarSenha(){
    string id;
    string senha;
    
    Menu::dispGetIdUser(&id);
    int idx = getIdxUsuarioById(id);
    
    if(idx < 0){
        Menu::errorNFuser();
        return;
    }
    
    Menu::dispGetSenhaUser(&senha);
    
    usuarios[idx]->setSenha(senha);
    
    Menu::success("Senha alterada com sucesso!");
}

void Biblioteca::listarUsuarios(){
    Menu::limpaTela();
    cout << Usuario::dispToString() << endl;
    for(size_t i = 0; i < usuarios.size(); i++){
        cout << usuarios[i]->toString() << endl;
    }
    Menu::pausaTela();
}


void Biblioteca::addUsuario(Usuario* novo){
    usuarios.push_back(novo);
}

void Biblioteca::removerUsuario(size_t idx){
    Usuario* user = usuarios[idx];
    delete user;
    usuarios.erase(usuarios.begin() + idx);
}

void Biblioteca::alterarEmailUsuario(size_t idx, string email){
    usuarios[idx]->setEmail(email);
}

void Biblioteca::alterarSenhaUsuario(size_t idx, string senha){
    usuarios[idx]->setSenha(senha);
}

int Biblioteca::getIdxUsuarioById(string id){
    for(size_t i = 0; i < usuarios.size(); i++){
        if(usuarios[i]->getId().compare(id) == 0){
            return i;
        }
    }
    return -1;
}

int Biblioteca::getIdxUsuarioByNome(string nome, string email){
    for(size_t i = 0; i < usuarios.size(); i++){
        if(usuarios[i]->getNome().compare(nome) == 0 && usuarios[i]->getEmail().compare(email) == 0){
            return i;
        }
    }
    return -1;
}

Usuario* Biblioteca::getUsuario(size_t idx){
    return usuarios[idx];
}

vector<Usuario*> Biblioteca::getListaUsuario(){
    return usuarios;
}


void Biblioteca::addLivro(Livro* livro){
    livros.push_back(livro);
}

void Biblioteca::removeLivro(size_t idx){
    Livro* livro = livros[idx];
    delete livro;
    livros.erase(livros.begin() + idx);
}

void Biblioteca::alterarQTD(size_t idx, int qtd){
    int i = qtd - livros[idx]->getCopiasTotais();
    livros[idx]->setCopiasTotais(qtd);
    livros[idx]->setCopias(livros[idx]->getCopias() + i);
}

int Biblioteca::getIdxLivroById(string id){
    for(size_t i = 0; i < livros.size(); i++){
        if(livros[i]->getId().compare(id) == 0){
            return i;
        }
    }
    return -1;
}

int Biblioteca::getIdxLivroByNome(string _titulo, string _autor){
    for(size_t i = 0; i < livros.size(); i++){
        if(livros[i]->getTitulo().compare(_titulo) == 0 && livros[i]->getAutor().compare(_autor) == 0){
            return i;
        }
    }
    return -1;
}

Livro* Biblioteca::getLivro(size_t idx){
    return livros[idx];
}

vector<Livro*> Biblioteca::getLista(){
    return livros;
}


void Biblioteca::addEmprestimo(Emprestimo* novo){
    emprestimos.push_back(novo);
}

void Biblioteca::removerEmprestimo(size_t idx){
    Emprestimo* emprestimo = emprestimos[idx];
    delete emprestimo;
    emprestimos.erase(emprestimos.begin() + idx);
}

Emprestimo* Biblioteca::getEmprestimo(size_t idx){
    return emprestimos[idx];
}

vector<Emprestimo*> Biblioteca::getListaEmprestimo(){
    return emprestimos;
}

