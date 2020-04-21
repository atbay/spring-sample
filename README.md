# spring-sample

 Spring bootのサンプルプロジェクトです。  
 RESTFulなAPIでデータベースにアクセスしてデータの更新、取得が行えます。
<br>

 ## 前提条件
- eclipse にLombokが導入済み
- java8以上がインストール済み
- postgresqlがインストール済み  

LombaokについてはpleiadesのLombok付きをインストールすると楽[pleiades](https://mergedoc.osdn.jp/)
<br>

## 動作確認環境
|環境  |サービス/バージョン  |
|---|---|
|実行環境  |Mac OS Catalina、Windows10  |
|開発環境  |eclipse pleiades 2019  |
|開発言語  |Java 8  |
|DB  |PostgreSQL 10  |
|Framework  |SpringBoot 2.2.6 |
|依存関係  |Jersey、MyBatis、Jackson |

## 手順
1. リポジトリーのクローン  
Gitのクライアントツール等でローカルにこのリポジトリをクローンする  
eclipseでインポートするためクローンする場所はメモしておく
<br>

2. eclipseにプロジェクトのインポート  
クローンしたリポジトリをeclipseでインポートする  

一般->既存プロジェクトをワークスペースへ   
![スクリーンショット 2020-04-21 9 17 13](https://user-images.githubusercontent.com/16896792/79811569-2a477e80-83b1-11ea-899b-b478e32dbaec.png)

クローンしたプロジェクト(ディレクトリ)を選択する  
![スクリーンショット 2020-04-21 9 32 10](https://user-images.githubusercontent.com/16896792/79812149-0127ed80-83b3-11ea-95b0-1a2da585db49.png)

インポート完了  
![スクリーンショット 2020-04-21 9 24 18](https://user-images.githubusercontent.com/16896792/79811785-e739db00-83b1-11ea-9517-88d0f263e5fc.png)

主なリソースの構成
```
├── build.gradle  # gradleの依存関係をまとめるファイル
├── ddl    # テスト用のDB生成DDL
│   ├── 01.role.sql
│   ├── 02.database.sql
│   └── 03.tables.sql
├── gradle    # gradle関連ファイル(特に使用しない)
│   └── wrapper
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── gradlew    # gradleバッチファイル、コマンドラインでビルド等する際に使用
├── gradlew.bat    # gradleバッチファイル、コマンドラインでビルド等する際に使用
├── postman_sample.json    # 試験用ツールのテンプレートPostman
├── settings.gradle    # gradle設定ファイル
└── src #プログラムファイル
    ├── main
    │   ├── java
    │   │   └── com
    │   │       └── example
    │   │           └── demo
    │   │               ├── SpringSampleApplication.java
    │   │               ├── api
    │   │               │   ├── organizations
    │   │               │   └── users
    │   │               │       ├── UserRestController.java
    │   │               │       └── UsersBean.java
    │   │               ├── config
    │   │               │   ├── JerseyConfig.java
    │   │               │   └── WebConfig.java
    │   │               └── domain
    │   │                   ├── entity
    │   │                   │   ├── organizations
    │   │                   │   │   ├── Organizations.java
    │   │                   │   │   ├── OrganizationsExample.java
    │   │                   │   │   └── OrganizationsKey.java
    │   │                   │   └── users
    │   │                   │       ├── Users.java
    │   │                   │       ├── UsersExample.java
    │   │                   │       └── UsersKey.java
    │   │                   ├── mapper
    │   │                   │   ├── organizations
    │   │                   │   │   └── OrganizationsMapper.java
    │   │                   │   └── users
    │   │                   │       └── UsersMapper.java
    │   │                   └── service
    │   │                       ├── organizations
    │   │                       └── users
    │   │                           ├── UsersService.java
    │   │                           └── UsersServiceImpl.java
    │   └── resources
    │       ├── application.properties
    │       ├── com    # ORマッパーのSQLファイル
    │       │   └── example
    │       │       └── demo
    │       │           └── domain
    │       │               └── mapper
    │       │                   ├── organizations
    │       │                   │   └── OrganizationsMapper.xml
    │       │                   └── users
    │       │                       └── UsersMapper.xml
    │       ├── generationConfig.xml    # MyBatisのORマッパー自動生成用の設定ファイル
    │       ├── generationConfig.xml.org
    │       ├── static
    │       └── templates
    └── test
        └── java
            └── com
```
ORマッパーの自動生成のやり方は[こちら](https://qiita.com/ketman55/items/abcc1e23dcac0cc268b5)を参照
<br>

3. テスト用データベース作成  
クローンしたリポジトリ内にあるDDLを以下の順番で実行してデータベースを作成する  
 - 01.role.sql   
 - 02.database.sql 
 - 03.tables.sql  

ユーザパスワードはspring/spring
<br>

4. アプリケーションの起動  
eclipseを用いたアプリケーションの起動  

ビューの表示でBootダッシュボードを表示する  
![スクリーンショット 2020-04-21 10 35 20](https://user-images.githubusercontent.com/16896792/79815500-da21e980-83bb-11ea-9c86-366489139b4e.png)

Bootダッシュボードが開くと対象のプロジェクトがリストアップされる  
![スクリーンショット 2020-04-21 10 39 57](https://user-images.githubusercontent.com/16896792/79815816-9e3b5400-83bc-11ea-8c56-aeb4217eb153.png)

右クリックでデバッグ、もしくは通常起動をクリックするとアプリが起動する  
![スクリーンショット 2020-04-21 10 40 09](https://user-images.githubusercontent.com/16896792/79815874-c460f400-83bc-11ea-8b2b-b3a990cc2044.png)

以下のコンソールが出力されると起動完了
```
Started SpringSampleApplication in 1.821 seconds
```
![スクリーンショット 2020-04-21 10 43 45](https://user-images.githubusercontent.com/16896792/79815974-01c58180-83bd-11ea-9452-d13a09230bfa.png)
<br>

5. 動作確認
アプリが起動したらRESTクライアントツールを用いて動作確認を実施する  
テストはChromeAppのPostmanを使用する(PostmanでなくてもCurl等のツールがあればそちらで問題無し)  
インストールは[こちら](https://www.postman.com/downloads/)を参照  
Postmanを使用する場合はリポジトリにある以下の定義がインポートして使用可能です。
```
postman_sample.json
```

インポートすると以下の定義が読み込まれます。  
![スクリーンショット 2020-04-21 10 52 52](https://user-images.githubusercontent.com/16896792/79816485-5289aa00-83be-11ea-86bb-98fc3692aed3.png)

それぞれユーザの一覧取得、ID指定の取得、登録、更新です。

## 最後に
今回テーブルUsersとOrganizations２つ用意し、サンプルのAPIとしてUsersがあります。  
基本的にはUsersを参考にすればOrganizationsのAPIも作成できると思います。  
手順ではeclipse上で動作確認していますが、gradleでjarを生成すればTomcatが同梱されたモジュールが生成できるので、
スタンドアロンで動作させる事も可能です。モジュールの生成方法等はeclipseでやる方法やバッチファイルから実施する方法が
あるので、やりやすい方を調べて試してください。