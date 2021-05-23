package homework.blog;

import homework.blog.model.Category;
import homework.blog.model.Post;
import homework.blog.storage.PostStorage;
import homework.blog.storage.PostStorageImpl;

import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Main implements PostStorageImpl {

    static PostStorage postStorage = new PostStorage();
    static Scanner scanner = new Scanner(System.in);

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
                    case DELETE_POST -> deletePost();
                    case CHANGE_POST -> changePost();
                    case DELETE_BY_CATEGORY -> deletePostByCategory();
                    default -> System.out.println("Սխալ հրաման");
                }
            } catch (NumberFormatException e) {
                command = -1;
            }
        }

    }

    private static void deletePostByCategory() {
        System.out.println("Ներմուծեք թե որ կոտեգորիաի թոստերնեք ուզում ջնջել");
        System.out.println(Arrays.toString(Category.values()));
        String category = scanner.next();
        postStorage.deletePostByCategory(Category.valueOf(category.toUpperCase()));

    }

    private static void changePost() {
        System.out.println("Ներմուծեք վերնագիր՝ փոստի տեքստը և կատեգորիան փոխելու համար");
         String title = scanner.next();
         postStorage.changePost(title);
    }

    private static void deletePost() {
        System.out.println("Ներմուծեք վերնագիր՝ թոստը ջնջելու համար");
        String title = scanner.next();
        postStorage.deletePost(title);
    }

    private static void printPostsByCategory() {
       try {
           System.out.println("Ներմուծեք թե որ կոտեգորիաովեք ուզում փնտրել");
           System.out.println(Arrays.toString(Category.values()));
           String category = scanner.next();
           postStorage.printPostsByCategory(Category.valueOf(category.toUpperCase()));
       }catch (IllegalArgumentException e){
           e.getMessage();
           printPostsByCategory();
       }

    }

    private static void searchPostsByKeyword() {
        System.out.println("Ներմուծեք բառը");
        String keyword = scanner.next();
        postStorage.searchPostsByKeyword(keyword);
    }

    private static void addPost()  {
        try {
            Date date = new Date();
            Post post = new Post();
            System.out.println("Ներմուծեք վերնագիր");
            post.setTitle(scanner.next());
            System.out.println("Ներմուծեք տեքստը");
            post.setText(scanner.next());
            System.out.println(Arrays.toString(Category.values()));
            System.out.println("Ներմուծեք ձեր նախընտրած կատեգորիան");
            post.setCategory(Category.valueOf(scanner.next().toUpperCase()));
            post.setCreatedDate(date);
            postStorage.addPost(post);
            System.out.println("Շնորհակալություն փոսթը ավելացվել է");
        }catch (ArrayIndexOutOfBoundsException e){
            e.getMessage();
        }
        catch (NumberFormatException e){
            e.getMessage();
        } catch (IllegalArgumentException | EnumConstantNotPresentException e){
            e.getMessage();
            addPost();
        }


    }

    private static void getPostByTitle(String title) {
        System.out.println(postStorage.getPostByTitle(title));
    }

}
