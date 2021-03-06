public class RobotTest2 {
    public interface RobotConnection extends AutoCloseable {
        void moveRobotTo(int x, int y);
        @Override
        void close();
    }
    public interface RobotConnectionManager {
        RobotConnection getConnection();
    }
    public static class RobotConnectionException extends RuntimeException {

        public RobotConnectionException(String message) {
            super(message);

        }

        public RobotConnectionException(String message, Throwable cause) {
            super(message, cause);
        }
    }
    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        for (int i = 0; i < 3; i++) {
            try (RobotConnection rc = robotConnectionManager.getConnection()) {
                rc.moveRobotTo(toX, toY);
                i=3;
            } catch (RobotConnectionException e){
                if(i==2){
                    throw e;
                }
            }
            catch (Throwable t) {
                throw t;
            }
        }

    }

}
