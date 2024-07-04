package entity;

import java.awt.Rectangle;
import main.GamePanel;
import object.OBJ_Axe;
import object.OBJ_Key;
import object.OBJ_Potion_Red;
import object.OBJ_Shield_Blue;
import object.OBJ_Shield_Wood;
import object.OBJ_Sword_Normal;

public class NPC_Merchant extends Entity {
    
    public NPC_Merchant(GamePanel gp){
        super(gp);
        
        direction = "down";
        speed = 1;
        
        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16;
        solidArea.width = 32;
        solidArea.height = 32;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        
        getImage();
        setDialogue();
        setItems();
    }
    public void getImage(){
        
        up1 = setup("/npc/merchant_down_1",gp.tileSize,gp.tileSize);
        up2 = setup("/npc/merchant_down_2",gp.tileSize,gp.tileSize);
        down1 = setup("/npc/merchant_down_1",gp.tileSize,gp.tileSize);
        down2 = setup("/npc/merchant_down_2",gp.tileSize,gp.tileSize);
        left1 = setup("/npc/merchant_down_1",gp.tileSize,gp.tileSize);
        left2 = setup("/npc/merchant_down_2",gp.tileSize,gp.tileSize);
        right1 = setup("/npc/merchant_down_1",gp.tileSize,gp.tileSize);
        right2 = setup("/npc/merchant_down_2",gp.tileSize,gp.tileSize);
        
    }
    public void setDialogue(){
        
        dialogues[0][0] = "Hehe, bạn đã tim ra được tôi.\nTôi có một vài thứ hay ho.\nBạn có muốn trao đổi không?";
        dialogues[1][0] = "Hẹn bạn trở lại, Bye Bye";
        dialogues[2][0] = "Bạn chưa có đủ tiền!";
        dialogues[3][0] = "Bạn không thể mang thêm đồ nữa!";
        dialogues[4][0] = "Bạn không thể bán vũ khí đang sử dụng!";
        
    }
    public void setItems(){
        inventory.add(new OBJ_Potion_Red(gp));
        inventory.add(new OBJ_Key(gp));
        inventory.add(new OBJ_Sword_Normal(gp));
        inventory.add(new OBJ_Axe(gp));
        inventory.add(new OBJ_Shield_Wood(gp));
        inventory.add(new OBJ_Shield_Blue(gp));
    }
    public void speak(){
        
        facePlayer();
        gp.gameState = gp.tradeState;
        gp.ui.npc = this;
    }
}
