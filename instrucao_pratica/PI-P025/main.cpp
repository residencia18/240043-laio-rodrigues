#include"RedeSocial.hpp"

vector<Usuario*> RedeSocial::usuarios;
vector<Tweet*> RedeSocial::tweets;

int main(){
    RedeSocial::init();
    return 0;
}