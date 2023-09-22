ARG VARIANT="buster"
FROM mcr.microsoft.com/vscode/devcontainers/java:1-17-${VARIANT}

ARG PKG="git vim curl unzip zip sudo"

RUN apt-get update \
    && apt-get install -y ${PKG} 

ARG INSTALL_MAVEN="true"
ARG MAVEN_VERSION=""


ARG INSTALL_GRADLE="false"
ARG GRADLE_VERSION=""

RUN if [ "${INSTALL_MAVEN}" = "true" ]; then su vscode -c "umask 0002 && . /usr/local/sdkman/bin/sdkman-init.sh && sdk install maven \"${MAVEN_VERSION}\""; fi \
    && if [ "${INSTALL_GRADLE}" = "true" ]; then su vscode -c "umask 0002 && . /usr/local/sdkman/bin/sdkman-init.sh && sdk install gradle \"${GRADLE_VERSION}\""; fi

# Set the working directory

# enable git
RUN su vscode --command \
    'sudo git config --system --add safe.directory "/home/vscode/workspace"'

# [Optional] Uncomment this section to install additional OS packages.
# RUN apt-get update && export DEBIAN_FRONTEND=noninteractive \
#     && apt-get -y install --no-install-recommends <your-package-list-here>

# [Optional] Uncomment this line to install global node packages.
# RUN su vscode -c "source /usr/local/share/nvm/nvm.sh && npm install -g <your-package-here>" 2>&1
