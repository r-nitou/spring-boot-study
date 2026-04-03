# Javaが動く軽量なOS（アルパインLinux）をベースにする
FROM eclipse-temurin:21-jdk-alpine

# コンテナ内での作業場所を決める
WORKDIR /app

# JARファイルをコンテナの中にコピーする
# ファイル名は自分の target フォルダ内にある名前に合わせてる
COPY target/HelloWorld-0.0.1-SNAPSHOT.jar app.jar

#アプリを起動するコマンドを書く
ENTRYPOINT ["java", "-jar", "app.jar"]