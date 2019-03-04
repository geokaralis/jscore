//
// Created by George on 04/03/2019.
//

#ifndef JSCORE_BLOB_H
#define JSCORE_BLOB_H

#include "v8.h"

namespace js {
    namespace core {
        class Blob {
        public:
            const unsigned char *data;
            unsigned int size;

            v8::StartupData * Mount();

            Blob() = default;
            Blob(const unsigned char *data, unsigned int size);
            ~Blob();
        };
    }
}

#endif //JSCORE_BLOB_H
