//package com.abhay;

import java.util.*;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<>();

    public static void main(String[] args) {

        Album album = new Album("Album1","Ed sheeran");

        album.addSong("Shape of you",3.53);
        album.addSong("Perfect",4.23);
        album.addSong("Shivers",3.27);
        albums.add(album);

        album = new Album("Album2","Justin Bieber");

        album.addSong("Sorry",3.20);
        album.addSong("Baby",3.34);
        album.addSong("STAY",2.21);

        albums.add(album);

        LinkedList<Song> playList_1 = new LinkedList<>();

        albums.get(0).addToPlayList("Shape of you",playList_1);
        albums.get(0).addToPlayList("Shivers",playList_1);
        albums.get(1).addToPlayList("Sorry",playList_1);
        albums.get(1).addToPlayList("STAY",playList_1);

        play(playList_1);

    }

    private static void play(LinkedList<Song> playList){
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();

        if(playList.size() == 0){
            System.out.println("This playlist have no song");
        }else {
            System.out.println("Now playing " + listIterator.next().toString());
            printMenu();
        }

        while(!quit){
            int action = sc.nextInt();
            sc.nextLine();

            switch (action){

                case 0:
                    System.out.println("Playlist complete");
                    quit = true;
                    break;

                case 1:
                    if(!forward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Now playing "+listIterator.next().toString());
                    }else {
                        System.out.println("no song availble, reached to the end of the list");
                        forward = false;
                    }
                    break;
                case 2:
                    if(forward){
                        if (listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Now playing "+listIterator.previous().toString());
                    }else {
                        System.out.println("we are the first song");
                        forward = false;
                    }
                    break;

                case 3:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            System.out.println("Now playing "+listIterator.previous().toString());
                            forward = false;
                        }else {
                            System.out.println("we are at the start of the list");
                        }
                    }else {
                        if(listIterator.hasNext()){
                            System.out.println("now playing "+listIterator.next().toString());
                            forward = true;
                        }else {
                            System.out.println("we have reached to the end of list");
                        }
                    }
                    break;

                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if (playList.size() >0){
                        listIterator.remove();
                        if(listIterator.hasNext()){
                            System.out.println("now playing "+listIterator.next().toString());
                        }
                        else {
                            if(listIterator.hasPrevious())
                            System.out.println("now playing "+listIterator.previous().toString());
                        }
                    }

            }
        }
    }

    private static void printMenu(){
        System.out.println("Available options\n press");
        System.out.println("0 - to quit\n"+
                "1 - to play next song\n"+
                "2 - to play previous song\n"+
                "3 - to replay the current song\n"+
                "4 - list of all songs \n"+
                "5 - print all available options\n"+
                "6 - delete current song");
    }

    private static void printList(LinkedList<Song> playList){
        Iterator<Song> iterator = playList.iterator();
        System.out.println("-----------------");

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("-----------------");
    }

}