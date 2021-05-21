package homework.blog.storage;

public interface PostStorageImpl {

     int EXIT = 0;
     int ADD_POST = 1;
     int SEARCH_POST = 2;
     int POSTS_BY_CATEGORY = 3;
     int ALL_POSTS = 4;

     static void printCommands() {
          System.out.println("Ներմուծեք " + EXIT + " դուրս գալու համար");
          System.out.println("Ներմուծեք " + ADD_POST + " փոստ ավելացնելու համար");
          System.out.println("Ներմուծեք " + SEARCH_POST + " փնտրել փոստ անունով կամ տեքստով");
          System.out.println("Ներմուծեք " + POSTS_BY_CATEGORY + " տպել փոսթերը ըստ կատեգորիաի");
          System.out.println("Ներմուծեք " + ALL_POSTS + " տպել բոլոր փոստեևը");

     }

}
