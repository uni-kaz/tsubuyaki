package jp.kobe_u.cs.daikibo.tsubuyaki.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jp.kobe_u.cs.daikibo.tsubuyaki.entity.Tsubuyaki;
import jp.kobe_u.cs.daikibo.tsubuyaki.service.TsubuyakiService;

@Controller
public class TsubuyakiController {
    @Autowired
    TsubuyakiService ts;

    /**
     * タイトル画面を表示する
     * 
     * @return
     */
    @GetMapping("/")
    String showIndex() {
        return "index";
    }

    /**
     * メイン画面を表示する
     * 
     * @param model
     * @return
     */
    @GetMapping("/read")
    String showTsubuyakiList(Model model) {
        // 全つぶやきを取得
        List<Tsubuyaki> list = ts.getAllTsubuyaki();
        // モデル属性にリストをセット
        model.addAttribute("tsubuyakiList", list);
        // 空フォームをセット
        model.addAttribute("tsubuyakiForm", new TsubuyakiForm());
        // リスト画面を返す
        return "tsubuyaki_list";
    }

    /**
     * つぶやきを投稿する
     * 
     * @param form
     * @param model
     * @return
     */
    @PostMapping("/read")
    String postTsubuyaki(@ModelAttribute("tsubuyakiForm") TsubuyakiForm form, Model model) {
        // フォームからエンティティに移し替え
        Tsubuyaki t = new Tsubuyaki();
        t.setName(form.getName());
        t.setComment(form.getComment());
        // サービスに投稿処理を依頼
        ts.postTsubuyaki(t);
        // メイン画面に転送
        return "redirect:/read";
    }

    /**
     * つぶやきをキーワードで検索する
     * 
     * @param word
     * @return
     */
    @GetMapping("/search")
    String searchTsubuyaki(@RequestParam("keyword") String word, Model model) {
        // キーワードにマッチしたつぶやきを取得
        List<Tsubuyaki> list = ts.searchTsubuyaki(word);
        // モデル属性にリストをセット
        model.addAttribute("tsubuyakiList", list);
        // 検索結果画面を返す
        return "search";
    }
}
