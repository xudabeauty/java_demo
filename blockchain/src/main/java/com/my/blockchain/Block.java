package com.my.blockchain;

public class Block {
    public String hash;
    public String previousHash;
    public String data;//区块
    public long timestamp;//时间戳
    public int announce;//增加一个随机数
    public Block(String data,String previousHash) {
        this.data=data;
        this.previousHash=previousHash;
        this.hash=calculateHash();
    }
    //计算hash值：上个区块的hash+时间戳+随机数+数据
    public String calculateHash() {
        String calculateHash=Util.applySha256(previousHash+Long.toString(timestamp)+Integer.toString(announce)+data);
        return calculateHash;
    }
    
    public void mineBlock(int difficulity) {
        String target=new String(new char[difficulity]).replace('\0', '0');
        while(!hash.substring(0,difficulity).equals(target)) {
            announce++;
            hash=calculateHash();
        }
        System.out.println("Block Mined!"+hash);
        
    }
    
    public static void main(String[] args) {
        Block gensisiBlock=new Block("hi, I am first block", "0");
        System.out.println("Hash for first block"+gensisiBlock.hash);
        Block secondBlock=new Block("hi,I'am second block", gensisiBlock.hash);
        System.out.println("Hash for second block"+secondBlock.hash);
        Block thirdBlock=new Block("hi,I'm thirtd block", secondBlock.hash);
        System.out.println("Hash for third block"+thirdBlock.hash);
    }
}
