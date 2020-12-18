public class RobotTest {
    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    public static class Robot {
        int x = 0;
        int y = 0;
        Direction direction = Direction.UP;

        public Direction getDirection() {
            return direction;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void turnLeft() {
            System.out.println("Поворот против часовой стрелки");
            if (direction == Direction.DOWN) {
                this.direction = Direction.RIGHT;
                return;

            }

            if (direction == Direction.UP) {
                this.direction = Direction.LEFT;
                return;
            }

            if (direction == Direction.LEFT) {
                this.direction = Direction.DOWN;
                return;
            }

            if (direction == Direction.RIGHT) {
                this.direction = Direction.UP;
                return;
            }
        }

        public void turnRight() {
            System.out.println("поворот по часовой стрелке");
            if (this.direction == Direction.DOWN) {
                System.out.println("Вниз -> влево");
                this.direction = Direction.LEFT;
                return;
            }

            if (this.direction == Direction.UP) {
                System.out.println("Вверх -> вправо");
                this.direction = Direction.RIGHT;
                return;
            }

            if (this.direction == Direction.LEFT) {
                System.out.println("Влево -> вверх");
                this.direction = Direction.UP;
                return;
            }

            if (this.direction == Direction.RIGHT) {
                System.out.println("Вправо -> вниз");
                this.direction = Direction.DOWN;
                return;
            }
        }

        public void stepForward() {
            System.out.println("движение");
            if (direction == Direction.DOWN) {
                System.out.println("вниз");
                this.y--;
            }

            if (direction == Direction.UP) {
                System.out.println("вверх");
                this.y++;
            }

            if (direction == Direction.LEFT) {
                System.out.println("налево");
                this.x--;
            }

            if (direction == Direction.RIGHT) {
                System.out.println("направо");
                this.x++;
            }
        }
        public static void moveRobot(Robot robot, int toX, int toY) {
            if (robot.getX() < toX) {
                if (robot.getDirection() == Direction.UP) {
                    robot.turnRight();
                } else if (robot.getDirection() == Direction.DOWN) {
                    robot.turnLeft();
                } else if (robot.getDirection() == Direction.LEFT) {
                    robot.turnRight();
                    robot.turnRight();
                }
            } else if (robot.getX() > toX) {
                if (robot.getDirection() == Direction.UP) {
                    robot.turnLeft();
                } else if (robot.getDirection() == Direction.DOWN) {
                    robot.turnRight();
                } else if (robot.getDirection() == Direction.RIGHT) {
                    robot.turnLeft();
                    robot.turnLeft();
                }
            }
            while (robot.getX() != toX) {
                robot.stepForward();
            }

            if (robot.getY() < toY) {
                if (robot.getDirection() == Direction.DOWN) {
                    robot.turnRight();
                    robot.turnRight();
                } else if (robot.getDirection() == Direction.LEFT) {
                    robot.turnRight();
                } else if (robot.getDirection() == Direction.RIGHT) {
                    robot.turnLeft();
                }
            } else if (robot.getY() > toY) {
                if (robot.getDirection() == Direction.UP) {
                    robot.turnRight();
                    robot.turnRight();
                } else if (robot.getDirection() == Direction.LEFT) {
                    robot.turnLeft();
                } else if (robot.getDirection() == Direction.RIGHT) {
                    robot.turnRight();
                }
            }
            while (robot.getY() != toY) {
                robot.stepForward();
            }
        }
    }

    public static void main(String[] args) {
        Robot r = new Robot();
        Robot.moveRobot(r,3,-3);
    }
}
