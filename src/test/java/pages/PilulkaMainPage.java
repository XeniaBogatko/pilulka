package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class PilulkaMainPage {

    private final SelenideElement emailInput = $("#email");
    private final SelenideElement passInput = $("#password");
    private final String addedItem = "Nutrend Excelent Protein Bar 9 x 85 g";
    private SelenideElement
            logo = $(".logo__header"),
            medicineButton = $("[data-root-item=\"item-1032\"]"),
            additivesButton = $("[data-root-item=\"item-1089\"]"),
            motherButton = $("[data-root-item=\"item-1167\"]"),
            electroButton = $("[data-root-item=\"item-2421\"]"),
            cosmeticButton = $("[data-root-item=\"item-1399\"]"),
            drugstoreButton = $("[data-root-item=\"item-2120\"]"),
            foodButton = $("[data-root-item=\"item-1513\"]"),
            sportButton = $("[data-root-item=\"item-1583\"]"),
            toothButton = $("[data-root-item=\"item-1625\"]"),
            healthButton = $("[data-root-item=\"item-6899\"]"),
            eroticaButton = $("[data-root-item=\"item-5472\"]"),
            animalButton = $("[data-root-item=\"item-14050\"]"),
            searchInput = $("#js-search-form-q"),
            searchResult = $("#product-list"),
            subMenu = $$(".main-nav__category-title.js_level-2").findBy(text("Proteinové potraviny")),
            chosenItem = $(byText(addedItem)),
            addItem = $$("#js-add-to-cart-first").get(2),
            basket = $(".btn.btn-primary.btn-sm.px-3.d-inline-block.fwb"),
            basketId = $("#js-cart-open"),
            saleLink = $("#js-mobile-banner-car-cart [href=\"/vyprodej\"]"),
            basketSubMenu = $("#js-mobile-banner-car-cart"),
            mainTitle = $("#main-title"),
            controlItem = $(".ml-2.mr-2.ml-md-0.mr-md-0"),
            authUser = $("[title=\"Přihlásit se\"]"),
            authButton = $$("[data-method=\"Regular\"]").last(),
            checkAuth = $(".js-validate-error-label"),
            modalWindow = $(byText("Kdy bude zboží u vás?")),
            modalWindowCloseButton = $$("[aria-label=\"Zavřít modální okno\"]").get(1),
            checkFooter = $$(".ml-lg-4.pl-lg-4.pl-1.ml-1.fwn.footer__bottom-cs-links").get(2);

    public PilulkaMainPage openPage() {
        step("Open 'https://www.pilulka.cz/'", () ->
                open("https://www.pilulka.cz/"));

        if ($(".footer__cookie").isDisplayed()) {
            $(byText("Odmítnout všechny cookies")).click();
        }
        return this;
    }

    public void checkMenuItems() {
        step("Check menu item name 'Léky'", () ->
                medicineButton.shouldHave(text("Léky")));
        step("Check menu item name 'Doplňky stravy'", () ->
                additivesButton.shouldHave(text("Doplňky stravy")));
        step("Check menu item name 'Matka a dítě'", () ->
                motherButton.shouldHave(text("Matka a dítě")));
        step("Check menu item name 'Elektro'", () ->
                electroButton.shouldHave(text("Elektro")));
        step("Check menu item name 'Kosmetika'", () ->
                cosmeticButton.shouldHave(text("Kosmetika")));
        step("Check menu item name 'Drogerie'", () ->
                drugstoreButton.shouldHave(text("Drogerie")));
        step("Check menu item name 'Potraviny, nápoje'", () ->
                foodButton.shouldHave(text("Potraviny, nápoje")));
        step("Check menu item name 'Sport'", () ->
                sportButton.shouldHave(text("Sport")));
        step("Check menu item name 'Ústa a zuby'", () ->
                toothButton.shouldHave(text("Ústa a zuby")));
        step("Check menu item name 'Zdravotnické potřeby'", () ->
                healthButton.shouldHave(text("Zdravotnické potřeby")));
        step("Check menu item name 'Erotika'", () ->
                eroticaButton.shouldHave(text("Erotika")));
        step("Check menu item name 'Veterina'", () ->
                animalButton.shouldHave(text("Veterina")));
    }

    public PilulkaMainPage search(String text) {
        step("Enter text for input", () ->
                searchInput.setValue(text)).pressEnter();
        return this;
    }

    public void checkInSearchResults(String headerText) {
        step("Checking in stock", () ->
                searchResult.shouldHave(text(headerText)));
    }

    public void checkEmptyBasket() {
        step("Hover basket", () ->
                basketId.hover());
        step("Check sub-menu item text", () -> {
            basketSubMenu.shouldHave(text("Ve svém košíku zatím nic nemáte"));
        });
    }

    public void openSales() {
        step("Hover basket", () ->
                basketId.hover());
        step("Open Sales", () -> {
            saleLink.click();
            mainTitle.shouldHave(text("Výprodej"));
        });
    }

    public void addItemInBasket() {
        step("Hover 'Sport' button in the menu", () ->
                sportButton.hover());
        step("Click by sub-menu item", () ->
                subMenu.click());
        step("Choose item in the list", () ->
                chosenItem.click());

        sleep(5000);
        step("Check if modal window is opened", () -> {
            if (modalWindow.isDisplayed()) {
                step("Close modal window", () -> {
                    modalWindowCloseButton.click();
                    logo.hover();
                });
            }
        });

        step("Add item in the basket", () -> {
            addItem.click();
        });

        step("Go to the basket", () ->
                basket.click());
        step("Check that the basket contains the item", () ->
                controlItem.shouldHave(text(addedItem)));
    }

    @Step("Login with {username}/{password}")
    public void loginWithError(String username, String password) {
        step("Click by authorization button", () ->
                authUser.click());
        step("Enter username", () ->
                emailInput.sendKeys(username));
        step("Enter password", () ->
                passInput.sendKeys(password));
        step("Click by enter button", () ->
                authButton.click());
        step("Check text", () ->
                checkAuth.shouldHave(text("Vyplňte prosím váš e-mail")));
    }

    public void setCheckFooter(String testFooter) {
        step("Checking footer selection", () ->
                checkFooter.shouldHave(text(testFooter)));
    }
}