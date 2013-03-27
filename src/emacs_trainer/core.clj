(ns emacs-trainer.core)

(def shortcuts [{:area "emacs->general"
                 :shortcuts [{:key "C-g"
                              :desc "Abort the current operation"}
                             {:key "C-x C-v RET"
                              :desc "Reload current buffer"}]}
                {:area "emacs->dired"
                 :shortcuts [{:key "^"
                              :desc "Go to the parent directory"}]}
                {:area "sites->youtube"
                 :shortcuts [{:key "f"
                              :desc "Fullscreen video"}
                             {:key "1"
                              :desc "Play video at position 10%"}
                             {:key "2"
                              :desc "Play video at position 20%"}]}
                {:area "emacs->vc"
                 :shortcuts [{:key "C-x v +"
                              :desc "Update current file"}
                             {:key "C-x v ="
                              :desc "Diff file"}
                             {:key "C-x v v"
                              :desc "Checkin file"}]}
                {:area "chrome"
                 :shortcuts [{:key "C-S-b"
                              :desc "Toggle bookmark bar"}
                             {:key "C-d"
                              :desc "Bookmark current page"}]}])
                

