package pages;

import static com.codeborne.selenide.Selenide.open;

public class BlogPage {

    public void openBlogPage () {
        open("/blog");
    }
}
