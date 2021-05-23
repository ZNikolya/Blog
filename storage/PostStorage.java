package homework.blog.storage;

import homework.blog.model.Category;
import homework.blog.model.Post;

import java.util.Scanner;

public class PostStorage {

    private Post[] array = new Post[10];
    private int size;


    public void addPost(Post post) {

        if (size == array.length) {
            extend();
        }
        array[size++] = post;
    }

    private void extend() {
        Post[] arraynew = new Post[array.length + 10];
        System.arraycopy(array, 0, arraynew, 0, array.length);
        array = arraynew;
    }

    public Post getPostByTitle(String title) {
        for (int i = 0; i < size; i++) {
            if (array[i].getTitle().equals(title)) {
                return array[i];
            }
        }
        return null;
    }

    public void printAllPosts() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " " + "\n");
        }
        System.out.println();
    }

    public void printPostsByCategory(Category category) {
        for (int i = 0; i < size; i++) {
            if (array[i].getCategory().equals(category)) {
                System.out.println(array[i]);
            }
        }
    }


    public void searchPostsByKeyword(String keyword) {
        for (int i = 0; i < size; i++) {
            if (array[i].getTitle().contains(keyword) || array[i].getText().contains(keyword)) {
                System.out.println(array[i]);
            }

        }
    }

    public void deletePost(String title) {
        for (int i = 0; i < size; i++) {
            if (array[i].getTitle().equalsIgnoreCase(title)) {
                deleteIndex(i);
                i = 0;
                size--;
            }
        }
    }

    public void deleteIndex(int index) {
        for (int i = size - 1; i > index; i--) {
            Post com = array[size - 1];
            System.arraycopy(array, 0, array, 1, size - 1);
            array[0] = com;

        }
    }

    public void deletePostByCategory(Category category) {
        try {
            int i = 0;
            while (array[i].getCategory().equals(category)) {
                deleteIndex(i);
                size--;
            }
        }catch (ArrayIndexOutOfBoundsException e){

        }

    }

    public String changePost(String title) {
        for (int i = 0; i < size; i++) {
            if (array[i].getTitle().equalsIgnoreCase(title)){
                Scanner scanner = new Scanner(System.in);
                array[i].setText(scanner.next());
                array[i].setCategory(Category.valueOf(scanner.next().toUpperCase()));
                return array[i].getText();
            }
        }
    return null;
    }

}

