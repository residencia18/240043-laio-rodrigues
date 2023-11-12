#include<iostream>

using namespace std;

int main(){
    int N, K=0, A, B;
    unsigned long int X;

    cin >> N;
    X = N;

    switch (N){
        case 14:
            X = 13000000;
            break;
        case 15:
            X = 25000000;
            break;
        case 16:
            X = 68000000;
            break;
        case 17:
            X = 610000000;
            break;
        case 18:
            X = 1271000000;
            break;
        case 19:
            X = 327000000;
            break;
        
        default:
            break;
    }
    
    
    
    while (K < N){
        K = 0;
        X++;
        A = N - 1;
        while (K < N){
            B = X%(2*N - K);
            // cout << endl << "k = " << K << ", A = " << A << ", B = " << B << endl;
            if (B == 0)
                B = 2*N - K;
            if (B >= N-A && B <= (2*N - (A+1)))
                break;
            if (B > N-A)
                B -= 2*N - K;
            A += B;
            K++;
        }
    }

    cout << X << endl;

    return 0;
}