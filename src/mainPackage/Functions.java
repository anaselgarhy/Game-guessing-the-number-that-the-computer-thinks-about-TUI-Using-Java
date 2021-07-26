package mainPackage;

public class Functions {
    public static short setNumber(short currentLevel){
        short range = (short)(currentLevel * 100 - 1);
        // The formula to get random number: Math.floor(Math.random()*(max-min+1)+min)
        short num = (short)Math.floor(Math.random() * (range - 2 + 1) + 2); // Generate random number between 2 and range
        // The simple formula to convert odd number to evin number : num - num % 2
        return (short)(num - num % 2); // return even number
    }
    public static short setNumber(short currentLevel, short startNumber){
        short range = (short)(currentLevel * 100);
        // The formula to get random number: Math.floor(Math.random()*(max-min+1)+min)
        short num = (short)Math.floor(Math.random() * (range - startNumber + 1) + startNumber); // Generate random number between startNumber and range
        // The simple formula to convert odd number to evin number : num - num % 2
        return  (short)(num - num % 2);
    }
    public static short setRandomNumber(short startNumber, short endNumber){
        short num = (short)Math.floor(Math.random() * (endNumber - startNumber + 1) + startNumber);
        return (short)(num - num % 2);
    }
}
