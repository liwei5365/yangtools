/*
 * Copyright (c) 2015 Cisco Systems, Inc. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.yangtools.yang.data.api.schema.tree;

import static java.util.Objects.requireNonNull;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import org.eclipse.jdt.annotation.NonNull;
import org.opendaylight.yangtools.yang.data.api.YangInstanceIdentifier.PathArgument;
import org.opendaylight.yangtools.yang.data.api.schema.NormalizedNode;

abstract class AbstractLeafCandidateNode implements DataTreeCandidateNode {
    private final NormalizedNode<?, ?> data;

    AbstractLeafCandidateNode(final NormalizedNode<?, ?> data) {
        this.data = requireNonNull(data);
    }

    final @NonNull Optional<NormalizedNode<?, ?>> dataOptional() {
        return Optional.of(data);
    }

    @Override
    public final Collection<DataTreeCandidateNode> getChildNodes() {
        return Collections.emptyList();
    }

    @Override
    public final PathArgument getIdentifier() {
        return data.getIdentifier();
    }

    @Override
    public final Optional<DataTreeCandidateNode> getModifiedChild(final PathArgument identifier) {
        requireNonNull(identifier);
        return Optional.empty();
    }
}