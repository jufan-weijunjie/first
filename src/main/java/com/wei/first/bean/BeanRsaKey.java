package com.wei.first.bean;

/**
 * FileName：BeanRsaKey
 *
 * @author 魏俊杰
 * @date 11:04 2019/5/21
 */
public class BeanRsaKey {

    /**主键自增id**/
    private Integer id;
    /**公钥**/
    private String publicKey;
    /**私钥**/
    private String privateKey;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    @Override
    public String toString() {
        return "BeanRsaKey{" +
                "id=" + id +
                ", publicKey='" + publicKey + '\'' +
                ", privateKey='" + privateKey + '\'' +
                '}';
    }
}
