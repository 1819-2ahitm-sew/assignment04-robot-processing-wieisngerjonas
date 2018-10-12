package at.htl.robot.model;

public class Robot {
    private int x;
    private int y;
    private Direction direction = Direction.SOUTH;

    //region Getter and Setter
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
    //endregion


    public void stepForward() {
        if (this.direction == Direction.NORTH) {
            this.y--;
        } else if (this.direction == Direction.EAST) {
            this.x++;
        } else if (this.direction == Direction.SOUTH) {
            this.y++;
        } else if (this.direction == Direction.WEST) {
            this.x--;
        }
    }

    public void rotateLeft() {
        if (this.direction == Direction.NORTH) {
            this.direction = Direction.WEST;
        } else if (this.direction == Direction.WEST) {
            this.direction = Direction.SOUTH;
        } else if (this.direction == Direction.SOUTH) {
            this.direction = Direction.EAST;
        } else if (this.direction == Direction.EAST) {
            this.direction = Direction.NORTH;
        }
    }
}