static int fib(int n){
    if(n == 0) return 0;
    if(n == 1) return 1;
    return fib(n-1) + fib(n-2);
}

int f = 0, k = 0;

while(f < 100){
    f = fib(k++);
    Console.Write($"{f} ");
}
