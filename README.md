## GRAALVM

### Macos

https://github.com/oracle/graal/releases

```
curl https://github.com/oracle/graal/releases/download/vm-1.0.0-rc16/graalvm-ce-1.0.0-rc16-macos-amd64.tar.gz

tar zxvf graalvm-ce-1.0.0-rc16-macos-amd64.tar.gz

mkdir /usr/local/Frameworks/graalvm/

cp ./graalvm-ce-1.0.0-rc16/Contents/Home /usr/local/Frameworks/graalvm/
```

```
vi .bash_profile 

export GRAALVM_HOME=/usr/local/Frameworks/graalvm
```

```. ~/.bash_profile```

```$GRAALVM_HOME/bin/java -version```

```$GRAALVM_HOME/bin/gu install native-image```

