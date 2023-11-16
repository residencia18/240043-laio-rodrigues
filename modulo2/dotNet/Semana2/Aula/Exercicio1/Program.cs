class Program{
    public static void Main(string[] args)
    {
        for (int i = 1; i <= 30; i++){
            if(i%3 == 0 || i%4 == 0)
                Console.Write($"{i} ");
        }
        Console.WriteLine();
    }
}


