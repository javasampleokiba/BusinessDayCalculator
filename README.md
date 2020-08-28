# BusinessDayCalculator
BusinessDayCalculatorは、営業日数を計算するJavaライブラリです。<br>
現状、日本の暦にのみ対応しており、「国民の祝日に関する法律」に従い、休日を自動判定します。

## Features
- 指定した日付が「国民の祝日」「振替休日」「国民の休日」であるかの判定、および休日名を取得する
- 指定した年（月）のすべての「国民の祝日」、「振替休日」、「国民の休日」の日付を取得する
- ２つの異なる日付の間の営業日数をカウントする
- ある日付からn営業日後の日付を取得する
- ある基準点（月初/月末など）からの第n営業日の日付を取得する

## Requirements
Java 6 or later<br>
（テストを実行したい場合は、Java 8 or later, JUnit5）

## Usage
下記ブログを参照してください。<br>
[[Java][サンプルコード] 国民の祝日を判定する](http://javasampleokiba.blog.fc2.com/blog-entry-19.html)<br>
[[Java][サンプルコード] 国民の祝日を判定する(続)](http://javasampleokiba.blog.fc2.com/blog-entry-20.html)<br>
[[Java][サンプルコード] 営業日数を計算する](http://javasampleokiba.blog.fc2.com/blog-entry-21.html)

## Note
- 皇室慶弔行事に伴う休日には対応していません
- 「国民の祝日に関する法律」施行前の祝日には対応していません
- 今後の法律改正により正常に動作しなくなる可能性があります（アップデートで随時更新予定です）
- 2151年以降の「春分の日」、「秋分の日」は求めることができません
- 複数の「国民の祝日」が重なる場合は、いずれか一方の情報しか取得できません（今後最初に祝日が重複するのは2876年と予測されています）

## License
LICENSEを参照してください。