/**@author alecc*/

public class MazeTraversal {
    //Test Maze From Problem Statement Is Set As The Default
    private  char[][] mazeDisplay =       {{'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
                                           {'#', '.', '.', '.', '#', '.', '.', '.', '.', '.', '.', '#'},
                                           {'.', '.', '#', '.', '#', '.', '#', '#', '#', '#', '.', '#'},
                                           {'#', '#', '#', '.', '#', '.', '.', '.', '.', '#', '.', '.'},
                                           {'#', '.', '.', '.', '.', '#', '#', '#', '.', '#', '.', '#'},
                                           {'#', '#', '#', '#', '.', '#', '.', '#', '.', '#', '.', '#'},
                                           {'#', '.', '.', '#', '.', '#', '.', '#', '.', '#', '.', '#'},
                                           {'#', '#', '.', '#', '.', '#', '.', '#', '.', '#', '.', '#'},
                                           {'#', '.', '.', '.', '.', '.', '.', '.', '.', '#', '.', '#'},
                                           {'#', '#', '#', '#', '#', '#', '.', '#', '#', '#', '.', '#'},
                                           {'#', '.', '.', '.', '.', '.', '.', '#', '.', '.', '.', '#'},
                                           {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}};

    private int indexColumn, indexRow; // Current Indexes of the Path
    private int indexColumnLast, indexRowLast; // Last Indexes of the Path
    private boolean hasEntered = false; // Detects whether the Path has left the start or not


    MazeTraversal() {
        findStart();
    }

    MazeTraversal(char[][] mD){
        mazeDisplay = mD;
        findStart();
    }

    MazeTraversal(char[][] mD, int row, int column){
        mazeDisplay = mD;
        indexColumn = column;
        indexRow = row;
        mazeDisplay[indexRow][indexColumn] = 'x';
    }


    /**
     * MethodName: traversal
     * Purpose: Recursively takes in inputs to update the position of the path and displays a direct correct path
     * through the maze.
     *
     * @param mD Updates the maze to where the path currently is to correctly display it later
     * @param row Index of the most recent path position within the correct row of the maze array
     * @param column Index of the most recent path position within the correct column of the maze array
     * @throws InterruptedException
     */
    public void traversal(char[][] mD, int row, int column) throws InterruptedException {
        Thread.sleep(100);
        indexColumnLast = indexColumn;
        indexRowLast = indexRow;

        mazeDisplay = mD;
        indexColumn = column;
        indexRow = row;

        mazeDisplay[indexRow][indexColumn] = 'x';


        if(!hasEntered){
            mazeDisplay[indexRowLast][indexColumnLast] = '.';
        }
        else if (mazeDisplay[indexRowLast][indexColumnLast] != 'B') {
            mazeDisplay[indexRowLast][indexColumnLast] = 'x';
        }

        printMaze();

        System.out.println();

        if((((indexColumn + 1) < 12) && ((indexRow + 1) < 12) && (indexColumn - 1 >= 0) && ((indexRow - 1) >= 0)) || !hasEntered) {//Makes Sure Next Step Is not out of bounds of the array
            hasEntered = true;
            if (mazeDisplay[indexRow][indexColumn + 1] == '.') {//Move Right
                traversal(mazeDisplay, indexRow, indexColumn + 1);
            } else if (mazeDisplay[indexRow - 1][indexColumn] == '.') {//Move Up
                traversal(mazeDisplay, indexRow - 1, indexColumn);
            } else if (mazeDisplay[indexRow][indexColumn - 1] == '.') {//Move Left
                traversal(mazeDisplay, indexRow, indexColumn - 1);
            } else if (mazeDisplay[indexRow + 1][indexColumn] == '.') {//Move Down
                traversal(mazeDisplay, indexRow + 1, indexColumn);
            }
            else{
                mazeDisplay[indexRow][indexColumn] = 'B';//Marks The Path That Led to a dead end
                if (mazeDisplay[indexRow][indexColumn + 1] == 'x') {//Move Right
                    traversal(mazeDisplay, indexRow, indexColumn + 1);
                } else if (mazeDisplay[indexRow - 1][indexColumn] == 'x') {//Move Up
                    traversal(mazeDisplay, indexRow - 1, indexColumn);
                } else if (mazeDisplay[indexRow][indexColumn - 1] == 'x') {//Move Left
                    traversal(mazeDisplay, indexRow, indexColumn - 1);
                } else if (mazeDisplay[indexRow + 1][indexColumn] == 'x') {//Move Down
                    traversal(mazeDisplay, indexRow + 1, indexColumn);
                }
            }

        }
        else{
            removeBacktrack();
            printMaze();
            System.out.println("\n-----------------------------");
            System.out.println("\nMAZE COMPLETED!");
        }


    }

    /**
     * MethodName: removeBacktrack
     * Purpose: Goes through the maze at the end of traversal and removes the points in which the program needed
     * to backtrack
     */
    public void removeBacktrack(){
        for(int i = 0; i < 12; i++){
            for(int j = 0; j < 12; j++){
                if(mazeDisplay[i][j] == 'B'){
                    mazeDisplay[i][j] = '.';
                }
            }
        }
    }

    /**
     * MethodName: printMaze
     * Purpose: Displays the current state of the given maze
     */
    public void printMaze(){
        for(int i = 0; i < 12; i++){
            for(int j = 0; j < 12; j++){
                System.out.print(mazeDisplay[i][j] + " ");
            }
            System.out.println();
        }
    }


    /**
     * MethodName: findStart
     * Purpose: Determines where the initial opening is and places the beginning of the path that traversal can
     * eventually use
     */
    private void findStart(){
        for(int i = 0; i < 12; i++){
            if(mazeDisplay[i][0] == '.'){
                mazeDisplay[i][0] = 'x';
                indexRow = i;
                indexColumn = 0;
            }
        }
    }

    public int getIndexColumn() { return indexColumn; }
    public int getIndexRow() { return indexRow; }
    public char[][] getMazeDisplay() { return mazeDisplay; }
}