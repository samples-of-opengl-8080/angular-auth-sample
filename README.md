angular-auth-sample
===================

AngularJS のセッション管理サンプル。

#動作環境
アプリケーション・サーバーには GlassFish 4.0 を使用する。

※JAX-RS と CDI の連携を利用しているので、 [バグ](http://qiita.com/opengl-8080/items/cfdde684b36efec50477) が発生するようなら修正する必要あり。

#仕組み
大きく、次の２箇所でセッションのチェックを行っている。

1. サーバーリクエスト時
2. ページ切替時


##サーバーリクエスト時のチェック
サーバー側は `Filter` を配置することで、 REST リクエストのうちセッション処理に係るリクエスト （`/rest/session`） 以外をチェックしている。

クライアント側は、 `$http` のインターセプターを定義して、レスポンスが 401 の場合にトップページへ強制遷移するようにしている。


##ページ切替時のチェック
ページ切替時のイベントは、以下の実装でハンドリングできる。

```js
angular
.module('mine', ['ngRoute'])
.run(function($rootScope, sessionService, $location) {
    $rootScope.$on('$routeChangeSuccess', function(event, current, next) {
        // ここにページ切替時の処理を書く
    });
});
```

ページ切り替えのたびにサーバーに確認のリクエストを送り、 401 が帰ってくればトップページに強制遷移するようにしている。


