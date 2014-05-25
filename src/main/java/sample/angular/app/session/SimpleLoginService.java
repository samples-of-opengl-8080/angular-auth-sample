package sample.angular.app.session;

import javax.ejb.Stateless;

/**
 * 単純なログイン処理を提供するクラス。
 * <p>
 * パスワードが "angular" であることをチェックします。
 */
@Stateless
public class SimpleLoginService {
    
    /**
     * パスワードをチェックする。
     * 
     * @param password パスワード
     * @return パスワードが有効な場合は true
     */
    public boolean validate(String password) {
        return "angular".equals(password);
    }
}
