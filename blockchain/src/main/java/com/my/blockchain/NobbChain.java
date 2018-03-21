package com.my.blockchain;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.GsonBuilder;

public class NobbChain {
    
    public static List<Block> blockchian=new ArrayList<Block>();
    public static int difficulty=5;
    
    public static void main(String[] args) {
        //增加区块到链上
        blockchian.add(new Block("hi,I'm first block", "0"));
        System.out.println("trying to mine block 1.....");
        blockchian.get(0).mineBlock(difficulty);
        
        blockchian.add(new Block("hi, I'm second block",blockchian.get(blockchian.size()-1).hash));
        System.out.println("trying to mine block 2.....");
        blockchian.get(1).mineBlock(difficulty);
        
        blockchian.add(new Block("hi, I'm third block",blockchian.get(blockchian.size()-1).hash));
        System.out.println("trying to mine block3....");
        blockchian.get(2).mineBlock(difficulty);
        String json = new GsonBuilder().setPrettyPrinting().create().toJson(blockchian);
        System.out.println(json);
    }
    
    public static boolean isValid() {
        Block currentBlock;
        Block previousBlock;
        for (int i = 1; i < blockchian.size(); i++) {
            currentBlock=blockchian.get(i);
            previousBlock=blockchian.get(i-1);
            if(!currentBlock.hash.equals(currentBlock.calculateHash())) {
                System.out.println("current hash not equal");
                return false;
            }
            if(!currentBlock.previousHash.equals(previousBlock.hash)) {
                System.out.println("previous hash not equal");
                return false;
            }
        }
        return true;
    }
}
