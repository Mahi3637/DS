public class Song {

    public static void typeLine(String line, int typingSpeed) throws InterruptedException {
        for (char c : line.toCharArray()) {
            System.out.print(c);
            System.out.flush();        
            Thread.sleep(typingSpeed); 
        }
        System.out.println();
    }

    public static void main(String[] args) throws InterruptedException {

        String[] lyrics = {
                "Oh, I used to say",
                "I would never fall in love again",
                "Untill i found her",
                "I said, I would never fall unless it's you I fall into",
                "i was lost within the darkness, but then I found her",
                "I found you"
        };

       
        double[] delays = {1.2, 1.5, 1.6, 1.5, 2.0};

        for (int i = 0; i < lyrics.length; i++) {
            typeLine(lyrics[i], 115);  
            Thread.sleep((int)(delays[i] * 800));
        }

        Thread.sleep(1500);
        System.out.println(" I found you. ");
    }
}