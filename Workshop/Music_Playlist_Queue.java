import java.util.LinkedList;
import java.util.Scanner;

class MediaPlayer {
    public void play(String media) {
        System.out.println("Playing: " + media);
    }
}

class MusicPlayer extends MediaPlayer {
    private LinkedList<String> playlist = new LinkedList<>();

    public void addSong(String song) {
        playlist.add(song);
    }

    public void addSongToFront(String song) {
        playlist.addFirst(song);
    }

    public void removeSong(String song) {
        playlist.remove(song);
    }

    public void playNext() {
        if (!playlist.isEmpty()) {
            String nextSong = playlist.poll();
            play(nextSong);
        } else {
            System.out.println("Playlist is empty.");
        }
    }

    public void showPlaylist() {
        System.out.println("Current Playlist: " + playlist);
    }
}

public class Music_Playlist_Queue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MusicPlayer player = new MusicPlayer();

        while (true) {
            System.out.println("1. Add Song\n2. Add Song to Front\n3. Remove Song\n4. Play Next\n5. Show Playlist\n6. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter song to add: ");
                    String song = scanner.nextLine();
                    player.addSong(song);
                    break;
                case 2:
                    System.out.print("Enter song to add to front: ");
                    String frontSong = scanner.nextLine();
                    player.addSongToFront(frontSong);
                    break;
                case 3:
                    System.out.print("Enter song to remove: ");
                    String removeSong = scanner.nextLine();
                    player.removeSong(removeSong);
                    break;
                case 4:
                    player.playNext();
                    break;
                case 5:
                    player.showPlaylist();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
