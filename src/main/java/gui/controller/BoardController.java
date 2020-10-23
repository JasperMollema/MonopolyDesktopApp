package gui.controller;

import gui.view.BoardView;

public class BoardController extends AbstractController {
    private BoardView boardView;

    public BoardController(BoardView boardView) {
        this.boardView = boardView;
    }

    @Override
    public String getControllerName() {
        return "BoardController";
    }

    @Override
    public void startController() {

    }
}
