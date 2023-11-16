static int rec(int n){
    if (n == 0){
        return 0;
    }

    rec(n-1);

    for(int i = 1; i <= n; i++){
        Console.Write($"{n*i} ");
    }
    Console.WriteLine("");
    return 1;
}

rec(8);