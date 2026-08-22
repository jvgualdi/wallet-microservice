FROM ubuntu:latest
LABEL authors="josevitor"

ENTRYPOINT ["top", "-b"]