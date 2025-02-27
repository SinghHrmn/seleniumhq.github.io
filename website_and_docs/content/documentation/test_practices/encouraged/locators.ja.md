---
title: "Tips on working with locators"
linkTitle: "Locators"
weight: 8
needsTranslation: true
description: >
    When to use which locators and how best to manage them in your code.
---

Take a look at examples of the [supported locator strategies]({{< ref "/documentation/webdriver/elements/locators.md" >}}).

一般に、HTMLのid属性が利用可能でユニークかつ一貫している場合、ページで要素を探す方法として適しています。
idは動作がとても速い傾向があり、複雑なDOMトラバースに伴う処理を省略できます。

ユニークなidが使えない場合、きれいに書かれたCSSセレクタが要素を探す方法として適しています。
XPathはCSSセレクタと同様に動作しますが、シンタックスは複雑で大抵の場合デバッグが困難です。
XPathはとても柔軟ですが、ブラウザベンダは性能テストを通常行っておらず、非常に動作が遅い傾向があります。

link textセレクタとpartial _linkText_ セレクタはa要素でしか動作しないという欠点があります。
加えて、これらはWebDriverの内部で[querySelectorAll](https://www.w3.org/TR/webdriver/#link-text)の呼び出しに置き換えられます。

タグ名によるロケータは危険な方法になり得ます。
大抵の場合ページ上には同じタグ名の要素が複数あります。タグ名は要素のコレクションを返す _findElements(By)_ メソッドを使う時にもっとも役に立ちます。

ロケータは可能な限り簡潔に、読みやすい状態を保つことを推奨します。
WebDriverでDOM構造のトラバースを行うのは重い処理となります。
検索の範囲を狭めた方がより良い結果を得られます。
