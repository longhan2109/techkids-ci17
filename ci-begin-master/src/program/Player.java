package program;

import tklibs.Mathx;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Set;

public class Player {
    BufferedImage image;
    double x;
    double y;

    public Player() {
        image = SpriteUtils.loadImage("assets/images/players/straight/0.png");
        x = Settings.PLAYER_START_X;
        y = Settings.PLAYER_START_Y;
    }

    public void render(Graphics g) {
        g.drawImage(image, (int)x, (int)y, null);
    }

    public void run() {
        double playerSpeed = Settings.PLAYER_SPEED;
        double vx = 0;
        double vy = 0;

        if(GameWindow.isUpPress) {
            vy -= playerSpeed;
        }
        if(GameWindow.isRightPress) {
            vx += playerSpeed;
        }
        if(GameWindow.isDownPress) {
            vy += playerSpeed;
        }
        if(GameWindow.isLeftPress) {
            vx -= playerSpeed;
        }

        if(vx != 0 && vy != 0) {
            double v = playerSpeed / Math.sqrt(2);
            vx = Math.signum(vx) * v; // 1 * 5 * sqrt(2)
            vy = Math.signum(vy) * v; // -1 * 5 * sqrt(2)
        }

        x += vx;
        y += vy;

        x = Mathx.clamp(x, 0, Settings.BACKGROUND_WIDTH - Settings.PLAYER_WIDTH);
        y = Mathx.clamp(y, 0, Settings.BACKGROUND_HEIGHT - Settings.PLAYER_HEIGHT);
    }
}
