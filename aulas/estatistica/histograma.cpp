#include<iostream>
#include<string>
#include<vector>
#include<ctime>

using namespace std;

int main(){

    srand(time(NULL));
    vector<int> dados;
    int histo[11] = {0};

    for(int i = 0; i < 100; i++){
        dados.push_back(rand()%6 + 1);
    }
    for(size_t i = 0; i < dados.size(); i++){
        dados[i] += rand()%6 + 1;
    }

    for(size_t i = 0; i < dados.size(); i++){
        histo[dados[i]-2] += 1;
    }
    for(int j = 15; j > 0; j--) {
        for(int i = 0; i < 11; i++){
            if(histo[i]/2-j >= 0){
                cout << " *";
            }else{
                cout << "  ";
            }
            cout << " ";
        }
        cout << endl;
    }


    cout << " 2  3  4  5  6  7  8  9  10 11 12" << endl;

    for(int i = 0; i < 11; i++){
        cout << " " << histo[i];
        if(histo[i] < 10)
            cout << " ";
    }
    cout << endl;
    return 0;
}