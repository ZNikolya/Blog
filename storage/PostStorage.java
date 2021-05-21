package homework.blog.storage;

import homework.blog.model.Post;

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

    public void printPostsByCategory(String category) {
        for (int i = 0; i < size; i++) {
            if (array[i].getCategory().equalsIgnoreCase(category)) {
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
}

