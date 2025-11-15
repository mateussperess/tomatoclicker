package com.example.atividade_jogo_clique;

public enum Tomatoes {
    TOMATE1("tomate1.png"),
    TOMATE2("tomate2.png"),
    TOMATE3("tomate3.png"),
    TOMATE4("tomate4.png"),
    TOMATE5("tomate5.png"),
    TOMATE6("tomate6.png"),
    TOMATE7("tomate7.png"),
    TOMATE8("tomate8.png"),
    TOMATE9("tomate9.png"),
    TOMATE10("tomate10.png");

    private final String imgName;
    Tomatoes(String imgName) {
        this.imgName = imgName;
    }

    public String getFileName() {
        return imgName;
    }
}
