package com.zoothopia;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {

        // =====================================
        // GAME WORLD
        // =====================================

        Pane gameWorld = new Pane();

        gameWorld.setStyle("-fx-background-color: #9BE58B;");


        // =====================================
        // ROADS
        // =====================================

        createRoads(gameWorld);


        // =====================================
        // TREES
        // =====================================

        createTrees(gameWorld);


        // =====================================
        // BUILDINGS
        // =====================================

        createBuildings(gameWorld);


        // =====================================
        // ANIMALS
        // =====================================

        createAnimals(gameWorld);


        // =====================================
        // PLAYER
        // =====================================

        Circle fox = new Circle(
                450,
                300,
                25,
                Color.ORANGE
        );

        gameWorld.getChildren().add(fox);


        // =====================================
        // SCENE
        // =====================================

        Scene scene = new Scene(
                gameWorld,
                1000,
                650
        );


        // =====================================
        // PLAYER MOVEMENT
        // =====================================

        scene.setOnKeyPressed(event -> {

            switch (event.getCode()) {

                case W:
                    fox.setCenterY(
                            fox.getCenterY() - 10
                    );
                    break;

                case S:
                    fox.setCenterY(
                            fox.getCenterY() + 10
                    );
                    break;

                case A:
                    fox.setCenterX(
                            fox.getCenterX() - 10
                    );
                    break;

                case D:
                    fox.setCenterX(
                            fox.getCenterX() + 10
                    );
                    break;
            }
        });


        stage.setTitle("Zoothopia 🦊");

        stage.setScene(scene);

        stage.show();
    }


    // =====================================
    // ROADS
    // =====================================

    private void createRoads(Pane world) {

        Rectangle horizontalRoad =
                new Rectangle(
                        0,
                        280,
                        1000,
                        100
                );

        horizontalRoad.setFill(Color.DARKGRAY);


        Rectangle verticalRoad =
                new Rectangle(
                        450,
                        0,
                        100,
                        650
                );

        verticalRoad.setFill(Color.DARKGRAY);


        world.getChildren().addAll(
                horizontalRoad,
                verticalRoad
        );
    }


    // =====================================
    // TREES
    // =====================================

    private void createTrees(Pane world) {

        createTree(world, 80, 80);
        createTree(world, 180, 120);

        createTree(world, 820, 80);
        createTree(world, 900, 150);

        createTree(world, 80, 550);
        createTree(world, 180, 500);

        createTree(world, 820, 550);
        createTree(world, 900, 480);
    }


    private void createTree(
            Pane world,
            double x,
            double y
    ) {

        Circle tree =
                new Circle(
                        x,
                        y,
                        30,
                        Color.DARKGREEN
                );

        world.getChildren().add(tree);
    }


    // =====================================
    // BUILDINGS
    // =====================================

    private void createBuildings(Pane world) {

        // Hospital
        createBuilding(
                world,
                600,
                50,
                220,
                100,
                "HOSPITAL"
        );


        // School
        createBuilding(
                world,
                50,
                200,
                250,
                70,
                "SCHOOL"
        );


        // Market
        createBuilding(
                world,
                600,
                200,
                200,
                70,
                "MARKET"
        );


        // Police Station
        createBuilding(
                world,
                600,
                450,
                220,
                80,
                "POLICE"
        );


        // Houses
        createBuilding(
                world,
                50,
                400,
                180,
                70,
                "RABBIT HOUSE"
        );


        createBuilding(
                world,
                250,
                450,
                160,
                70,
                "PANDA HOUSE"
        );
    }


    private void createBuilding(
            Pane world,
            double x,
            double y,
            double width,
            double height,
            String name
    ) {

        Rectangle building =
                new Rectangle(
                        x,
                        y,
                        width,
                        height
                );

        building.setFill(Color.BEIGE);

        building.setStroke(Color.DARKGREEN);


        Text label =
                new Text(
                        x + 10,
                        y + 40,
                        name
                );

        label.setFont(
                Font.font(16)
        );


        world.getChildren().addAll(
                building,
                label
        );
    }


    // =====================================
    // ANIMALS
    // =====================================

    private void createAnimals(Pane world) {

        createAnimal(
                world,
                350,
                150,
                "🐰"
        );


        createAnimal(
                world,
                250,
                350,
                "🐼"
        );


        createAnimal(
                world,
                700,
                350,
                "🦁"
        );


        createAnimal(
                world,
                350,
                520,
                "🐻"
        );
    }


    private void createAnimal(
            Pane world,
            double x,
            double y,
            String animal
    ) {

        Text character =
                new Text(
                        x,
                        y,
                        animal
                );

        character.setFont(
                Font.font(35)
        );


        world.getChildren().add(character);
    }


    // =====================================
    // MAIN
    // =====================================

    public static void main(String[] args) {

        launch();
    }
}