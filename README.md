# spring-sample

 Spring bootのサンプルプロジェクトです。  
 RESTFulなAPIでデータベースにアクセスしてデータの更新、取得が行えます。
<br>
<br>

 ## 前提条件
- eclipse にLombokが導入済み
- java8以上がインストール済み
- postgresqlがインストール済み  

LombaokについてはpleiadesのLombok付きをインストールすると楽[pleiades](https://mergedoc.osdn.jp/)
<br>
<br>

## 動作確認環境
|環境  |サービス/バージョン  |
|---|---|
|実行環境  |Mac OS  |
|開発環境  |eclipse pleiades 2019  |
|開発言語  |Java 8  |
|DB  |PostgreSQL 10  |
|Framework  |SpringBoot 2.2.6 |
|依存関係  |Jersey、MyBatis、Jackson |


## 手順
1. リポジトリーのクローン  
ローカルにこのリポジトリをクローンする
<br>
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
   1. 01.role.sql   
   2. 02.database.sql 
   3. 03.tables.sql  

