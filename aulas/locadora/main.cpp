#include"Data.hpp"

int main(){
    
    Data data(06, 01, 2001);
    Data data2(06, 01, 2002);
    
    int dias = data.diaEntre(data2);
    
    cout << dias << endl;
    
    return 0;
}