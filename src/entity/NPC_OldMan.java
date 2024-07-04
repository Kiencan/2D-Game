package entity;

import java.awt.Rectangle;
import java.util.Random;
import main.GamePanel;

public class NPC_OldMan extends Entity {
    
    public NPC_OldMan(GamePanel gp){
        super(gp);
        
        direction = "down";
        speed = 2;
        
        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 30;
        solidArea.height = 30;
        
        dialogueSet = -1;
        getImage();
        setDialogue();
    }
    public void getImage(){
        
        up1 = setup("/npc/oldman_up_1",gp.tileSize,gp.tileSize);
        up2 = setup("/npc/oldman_up_2",gp.tileSize,gp.tileSize);
        down1 = setup("/npc/oldman_down_1",gp.tileSize,gp.tileSize);
        down2 = setup("/npc/oldman_down_2",gp.tileSize,gp.tileSize);
        left1 = setup("/npc/oldman_left_1",gp.tileSize,gp.tileSize);
        left2 = setup("/npc/oldman_left_2",gp.tileSize,gp.tileSize);
        right1 = setup("/npc/oldman_right_1",gp.tileSize,gp.tileSize);
        right2 = setup("/npc/oldman_right_2",gp.tileSize,gp.tileSize);
        
    }
    public void setDialogue(){
        
        dialogues[0][0] = "Chào Kiên";
        dialogues[0][1] = "Chào mừng bạn đến hòn đảo\nVùng Đất Chết Chóc.";
        dialogues[0][2] = "Bạn muốn đi tìm kho báu\ncó phải không ?";
        dialogues[0][3] = "Ta từng là một bậc thầy phù thủy\nkhét tiếng nhất vùng này.";
        dialogues[0][4] = "Nhưng hiện tại tuổi tác đã quá cao\nnên ta không thể phiêu lưu được nữa.";
        dialogues[0][5] = "Chúc cậu may mắn!";
        
        dialogues[1][0] = "Nếu cậu cảm thấy mệt mỏi, hãy \nđến uống nước ở bờ sông";
        dialogues[1][1] = "Sau khi uống nước xong, quái vật \nsẽ xuất hiện trở lại";
        dialogues[1][2] = "Đừng làm bản thân mình khổ quá";
        
        dialogues[2][0] = "Làm thế nào để mở cửa nhỉ?";
        
    }
    public void setAction(){
        
        if(onPath == true){
            
            
//            int goalCol = 12;
//            int goalRow = 9;
            int goalCol = (gp.player.worldX + gp.player.solidArea.x)/gp.tileSize;
            int goalRow = (gp.player.worldY + gp.player.solidArea.y)/gp.tileSize;
            
            searchPath(goalCol, goalRow);
        }
        else {
            actionLockCounter ++;
        
            if (actionLockCounter == 120){
                Random random = new Random();
                int i  = random.nextInt(100)+1;

                if (i <= 25){
                    direction = "up"; 
                }
                if (i > 25 && i <= 50 ){
                    direction = "down";
                }
                if (i > 50 && i <= 75 ){
                    direction = "left";
                }
                if (i > 75 && i <= 100 ){
                    direction = "right";
                }
                actionLockCounter = 0;
            }
        }
    }
    public void speak(){
        
        facePlayer();
        startDialogue(this, dialogueSet);
        dialogueSet++;
        if(dialogues[dialogueSet][0] == null){
            dialogueSet--;
        }
//        onPath = true;
    }
}
