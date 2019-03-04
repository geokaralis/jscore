//
// Created by George on 04/03/2019.
//

#ifndef JSCORE_PRE_H
#define JSCORE_PRE_H

#include "v8.h"
#include "blob.h"

namespace js {
    namespace core {
        class Pre {
        public:
            void Initialize();
            void InitializeExternalStartupData();

            Pre() = default;
            ~Pre() = default;
        };
    } // namespace core
} // namespace js

#endif //JSCORE_PRE_H
