(ns emacs-trainer.core)

(def shortcuts [{:area "emacs->general"
                 :shortcuts [{:key "C-g"
                              :desc "Abort the current operation"}
                             {:key "C-x C-v RET"
                              :desc "Reload current buffer"}]}
                {:area "emacs->dired"
                 :shortcuts [{:key "^"
                              :desc "Go to the parent directory"}
                             {:key "g"
                              :desc "Refresh dired buffer"}]}
                {:area "sites->youtube"
                 :shortcuts [{:key "f"
                              :desc "Fullscreen video"}
                             {:key "1"
                              :desc "Play video at position 10%"}
                             {:key "2"
                              :desc "Play video at position 20%"}]},
                {:area "sites->gmail"
                 :shortcuts [{:key "x"
                              :desc "Mark current message"}
                             {:key "y"
                              :desc "Archive marked messages"}
                             {:key "u"
                              :desc "Return to conversation list"}
                             {:key "g i"
                              :desc "Go to inbox"}
                             {:Key "g l"
                              :desc "Go to label autocomplete input"}]}
                {:area "emacs->nrepl"
                 :shortcuts [{:key "C-c M-j"
                              :desc "Start nREPL server"}]}
                {:area "emacs->clojure-test"
                 :shortcuts [{:key "C-c ,"
                              :desc "Run tests"}
                             {:key "C-c M-,"
                              :desc "Run test"}
                             {:key "C-'"
                              :desc "Show exception name of test failure"]}
                {:area "emacs->vc"
                 :shortcuts [{:key "C-x v +"
                              :desc "Update current file"}
                             {:key "C-x v ="
                              :desc "Diff file"}
                             {:key "C-x v v"
                              :desc "Checkin file"}
                             {:key "C-x v l"
                              :desc "Show commit log"}]}
                {:area "chrome"
                 :shortcuts [{:key "C-S-b"
                              :desc "Toggle bookmark bar"}
                             {:key "C-d"
                              :desc "Bookmark current page"}]}])


                

