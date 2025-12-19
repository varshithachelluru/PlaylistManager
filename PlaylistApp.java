/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.Scanner;
// creating a node class
class Song {
    String name;
    Song next;

    Song(String name) {
        this.name = name;
        this.next = null;
    }
}

class Playlist{
    Song head;
    Song current;
    
    Playlist(){
     head = null;
     current = null;
    }

// adding a song to the playlist
 void addsong(String name){
    Song newsong = new Song(name);
    
    if(head==null){
        head=newsong;
        current=head;
    }
    else{
        Song temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newsong;
    }
}

// displaying songs in the playlist
void  displaysongs(){
    if(head==null){
        System.out.println("your playlist is empty");
        return;
    }
    else{
        System.out.println("Here is your playlist");
        Song temp=head;
        while(temp!=null){
            System.out.println("song name "+temp.name);
            temp=temp.next;
        }
    }
}

// deleting a song from the playlist
    void deletesong(String name) {
        if (head == null) {
            System.out.println("Your playlist is empty!");
            return;
        }

        if (head.name.equals(name)) {
            head = head.next;
            System.out.println("Song deleted!");
            return;
        }

        Song temp = head;
        while (temp.next != null && !temp.next.name.equals(name)) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Song not found!");
        } else {
            temp.next = temp.next.next;
            System.out.println("Song deleted!");
        }
    }
    
 // Play the next song in the playlist
    void playNextsong() {
        if (current == null) {
            System.out.println("No songs to play!");
            return;
        }

        System.out.println("Now playing: " + current.name);
        current = current.next;
    }
}

class PlaylistApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Playlist playlist = new Playlist();  // Create a playlist object
        int choice;

        while (true) {
            System.out.println("\n--- Playlist Menu ---");
            System.out.println("1. Add Song");
            System.out.println("2. Display Playlist");
            System.out.println("3. Delete Song");
            System.out.println("4. Play Next Song");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter song name: ");
                    String name = sc.nextLine();
                    playlist.addsong(name);
                    break;

                case 2:
                    playlist.displaysongs();
                    break;

                case 3:
                    System.out.print("Enter song name to delete: ");
                    String delName = sc.nextLine();
                    playlist.deletesong(delName);
                    break;

                case 4:
                    playlist.playNextsong();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}



    












    
