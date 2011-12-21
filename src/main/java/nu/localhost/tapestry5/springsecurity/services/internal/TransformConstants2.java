// Copyright 2006, 2007, 2008, 2009, 2011 The Apache Software Foundation
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package nu.localhost.tapestry5.springsecurity.services.internal;

import java.lang.reflect.Modifier;

import org.apache.tapestry5.MarkupWriter;
import org.apache.tapestry5.plastic.MethodDescription;
import org.apache.tapestry5.plastic.PlasticUtils;
import org.apache.tapestry5.runtime.Component;
import org.apache.tapestry5.runtime.ComponentEvent;
import org.apache.tapestry5.runtime.Event;
import org.apache.tapestry5.runtime.PageLifecycleListener;
import org.apache.tapestry5.services.TransformMethodSignature;
import org.apache.tapestry5.services.transform.ComponentClassTransformWorker2;

/**
 * Constants used by implementations of {@link org.apache.tapestry5.services.ComponentClassTransformWorker} and
 * {@link ComponentClassTransformWorker2}.
 * <p/>
 * Note: methods on transformed components will not be invoked <em>unless</em>
 * {@linkplain org.apache.tapestry5.model.MutableComponentModel#addRenderPhase(Class) the component model is updated to
 * identify the use of the corresponding render phase}.
 */
public final class TransformConstants2
{
    // Shared parameters of a whole bunch of lifecycle methods, representing the different
    // component render states.
    private static final String[] RENDER_PHASE_METHOD_PARAMETERS =
    { MarkupWriter.class.getName(), Event.class.getName() };

    private static final Class[] RENDER_PHASE_METHOD_PARAMETER_TYPES =
    { MarkupWriter.class, Event.class };

    /**
     * Signature for
     * {@link org.apache.tapestry5.runtime.Component#dispatchComponentEvent(org.apache.tapestry5.runtime.ComponentEvent)}
     * .
     * 
     * @see org.apache.tapestry5.annotations.OnEvent
     * @deprecated Deprecated in Tapestry 5.3, use {@link #DISPATCH_COMPONENT_EVENT_DESCRIPTION}.
     */
    public static final TransformMethodSignature DISPATCH_COMPONENT_EVENT = new TransformMethodSignature(
            Modifier.PUBLIC, "boolean", "dispatchComponentEvent", new String[]
            { ComponentEvent.class.getName() }, null);

    /**
     * Description for
     * {@link org.apache.tapestry5.runtime.Component#dispatchComponentEvent(org.apache.tapestry5.runtime.ComponentEvent)}
     * .
     * 
     * @see org.apache.tapestry5.annotations.OnEvent
     * @since 5.3.0
     */
    public static final MethodDescription DISPATCH_COMPONENT_EVENT_DESCRIPTION = PlasticUtils.getMethodDescription(
            Component.class, "dispatchComponentEvent", ComponentEvent.class);

    /**
     * Signature for {@link org.apache.tapestry5.runtime.PageLifecycleListener#containingPageDidLoad()}.
     * 
     * @deprecated Deprecated in 5.3, use {@link #CONTAINING_PAGE_DID_LOAD_DESCRIPTION}.
     */
    public static final TransformMethodSignature CONTAINING_PAGE_DID_LOAD_SIGNATURE = new TransformMethodSignature(
            "containingPageDidLoad");

    /**
     * Description for {@link org.apache.tapestry5.runtime.PageLifecycleListener#containingPageDidLoad()}.
     * 
     * @since 5.3.0
     */
    public static final MethodDescription CONTAINING_PAGE_DID_LOAD_DESCRIPTION = PlasticUtils.getMethodDescription(
            PageLifecycleListener.class, "containingPageDidLoad");

    /**
     * Signature for {@link org.apache.tapestry5.runtime.Component#postRenderCleanup()}.
     */
    public static final TransformMethodSignature POST_RENDER_CLEANUP_SIGNATURE = new TransformMethodSignature(
            "postRenderCleanup");

    /**
     * Signature for {@link org.apache.tapestry5.runtime.PageLifecycleListener#containingPageDidDetach()}.
     */
    public static final TransformMethodSignature CONTAINING_PAGE_DID_DETACH_SIGNATURE = new TransformMethodSignature(
            "containingPageDidDetach");

    /**
     * Signature for {@link org.apache.tapestry5.runtime.PageLifecycleListener#containingPageDidAttach()}.
     */
    public static final TransformMethodSignature CONTAINING_PAGE_DID_ATTACH_SIGNATURE = new TransformMethodSignature(
            "containingPageDidAttach");

    /**
     * Signature for {@link org.apache.tapestry5.runtime.PageLifecycleListener#restoreStateBeforePageAttach()}
     * 
     * @since 5.1.0.1
     */
    public static final TransformMethodSignature RESTORE_STATE_BEFORE_PAGE_ATTACH_SIGNATURE = new TransformMethodSignature(
            "restoreStateBeforePageAttach");

    /**
     * Signature for {@link org.apache.tapestry5.runtime.Component#setupRender(MarkupWriter, Event)}.
     * 
     * @see org.apache.tapestry5.annotations.SetupRender
     * @deprecated Deprecated in Tapestry 5.3, use {@link #SETUP_RENDER_DESCRIPTION}
     */
    public static final TransformMethodSignature SETUP_RENDER_SIGNATURE = renderPhaseSignature("setupRender");

    /**
     * Description for {@link org.apache.tapestry5.runtime.Component#setupRender(MarkupWriter, Event)}.
     * 
     * @see org.apache.tapestry5.annotations.SetupRender
     * @since 5.3.0
     */
    public static final MethodDescription SETUP_RENDER_DESCRIPTION = PlasticUtils.getMethodDescription(Component.class,
            "setupRender", RENDER_PHASE_METHOD_PARAMETER_TYPES);

    /**
     * Signature for {@link org.apache.tapestry5.runtime.Component#beginRender(MarkupWriter, Event)}.
     * 
     * @see org.apache.tapestry5.annotations.BeginRender
     */
    public static final TransformMethodSignature BEGIN_RENDER_SIGNATURE = renderPhaseSignature("beginRender");

    /**
     * Description for {@link org.apache.tapestry5.runtime.Component#beginRender(MarkupWriter, Event)}.
     * 
     * @see org.apache.tapestry5.annotations.BeginRender
     * @since 5.3.0
     */
    public static final MethodDescription BEGIN_RENDER_DESCRIPTION  = PlasticUtils.getMethodDescription(Component.class,
            "beginRender", RENDER_PHASE_METHOD_PARAMETER_TYPES);

    /**
     * Signature for {@link org.apache.tapestry5.runtime.Component#beforeRenderTemplate(MarkupWriter, Event)}.
     * 
     * @see org.apache.tapestry5.annotations.BeforeRenderTemplate
     */
    public static final TransformMethodSignature BEFORE_RENDER_TEMPLATE_SIGNATURE = renderPhaseSignature("beforeRenderTemplate");

    /**
     * Signature for {@link org.apache.tapestry5.runtime.Component#afterRenderTemplate(MarkupWriter, Event)}.
     * 
     * @see org.apache.tapestry5.annotations.BeforeRenderTemplate
     */
    public static final TransformMethodSignature AFTER_RENDER_TEMPLATE_SIGNATURE = renderPhaseSignature("afterRenderTemplate");

    /**
     * Signature for {@link org.apache.tapestry5.runtime.Component#beforeRenderBody(MarkupWriter, Event)}.
     * 
     * @see org.apache.tapestry5.annotations.BeforeRenderBody
     */
    public static final TransformMethodSignature BEFORE_RENDER_BODY_SIGNATURE = renderPhaseSignature("beforeRenderBody");

    /**
     * Signature for {@link org.apache.tapestry5.runtime.Component#afterRenderBody(MarkupWriter, Event)}.
     * 
     * @see org.apache.tapestry5.annotations.AfterRenderBody
     */
    public static final TransformMethodSignature AFTER_RENDER_BODY_SIGNATURE = renderPhaseSignature("afterRenderBody");

    /**
     * Signature for {@link org.apache.tapestry5.runtime.Component#afterRender(MarkupWriter, Event)}
     * 
     * @see org.apache.tapestry5.annotations.AfterRender
     */
    public static final TransformMethodSignature AFTER_RENDER_SIGNATURE = renderPhaseSignature("afterRender");

    /**
     * Signature for {@link org.apache.tapestry5.runtime.Component#cleanupRender(MarkupWriter, Event)}.
     * 
     * @see org.apache.tapestry5.annotations.CleanupRender
     */
    public static final TransformMethodSignature CLEANUP_RENDER_SIGNATURE = renderPhaseSignature("cleanupRender");

    /**
     * Description for {@link org.apache.tapestry5.runtime.Component#cleanupRender(MarkupWriter, Event)}.
     * 
     * @see org.apache.tapestry5.annotations.CleanupRender
     * @since 5.3.0
     */
    public static final MethodDescription CLEANUP_RENDER_DESCRIPTION  = PlasticUtils.getMethodDescription(Component.class,
            "cleanupRender", RENDER_PHASE_METHOD_PARAMETER_TYPES);

    private static TransformMethodSignature renderPhaseSignature(String name)
    {
        return new TransformMethodSignature(Modifier.PUBLIC, "void", name, RENDER_PHASE_METHOD_PARAMETERS, null);
    }
}
