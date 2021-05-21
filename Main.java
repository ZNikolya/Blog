package homework.blog;

import homework.blog.model.Post;
import homework.blog.storage.PostStorage;
import homework.blog.storage.PostStorageImpl;

import java.util.Date;
import java.util.Scanner;

public class Main implements PostStorageImpl {

    static PostStorage postStorage = new PostStorage();
    static Scanner scanner = new Scanner(System.in);
    static Date date = new Date();

    public static void main(String[] args) {

        boolean run = true;
        while (run) {

            PostStorageImpl.printCommands();

            int command;
            try {

                command = Integer.parseInt(scanner.next());
                switch (command) {
                    case EXIT -> run = false;
                    case ADD_POST -> addPost();
                    case SEARCH_POST -> searchPostsByKeyword();
                    case POSTS_BY_CATEGORY -> printPostsByCategory();
                    case ALL_POSTS -> postStorage.printAllPosts();
                    default -> System.out.println("Սխալ հրաման");
                }
            } catch (NumberFormatException e) {
                command = -1;
            }
        }

    }

    private static void printPostsByCategory() {
        System.out.println("Ներմուծեք կատեգորիան");
        String category = scanner.next();
        postStorage.printPostsByCategory(category);
    }

    private static void searchPostsByKeyword() {
        System.out.println("Ներմուծեք բառը");
        String keyword = scanner.next();
        postStorage.searchPostsByKeyword(keyword);
    }

    private static void addPost() {

        Post post = new Post();
        System.out.println("Ներմուծեք վերնագիր");
        post.setTitle(scanner.next());
        System.out.println("Ներմուծեք տեքստը");
        post.setText(scanner.next());
        System.out.println("Ներմուծեք կատեգորիան");
        post.setCategory(scanner.next());
        post.setCreatedDate(date);
        postStorage.addPost(post);
        System.out.println("Շնորհակալություն փոսթը ավելացվել է");

    }

    private static void getPostByTitle(String title) {
        System.out.println(postStorage.getPostByTitle(title));
    }

}
