package org.gradle.accessors.dm;

import org.gradle.api.NonNullApi;
import org.gradle.api.artifacts.MinimalExternalModuleDependency;
import org.gradle.plugin.use.PluginDependency;
import org.gradle.api.artifacts.ExternalModuleDependencyBundle;
import org.gradle.api.artifacts.MutableVersionConstraint;
import org.gradle.api.provider.Provider;
import org.gradle.api.provider.ProviderFactory;
import org.gradle.api.internal.catalog.AbstractExternalDependencyFactory;
import org.gradle.api.internal.catalog.DefaultVersionCatalog;
import java.util.Map;
import javax.inject.Inject;

/**
 * A catalog of dependencies accessible via the `libs` extension.
*/
@NonNullApi
public class LibrariesForLibs extends AbstractExternalDependencyFactory {

    private final AbstractExternalDependencyFactory owner = this;
    private final AccompanistLibraryAccessors laccForAccompanistLibraryAccessors = new AccompanistLibraryAccessors(owner);
    private final AndroidLibraryAccessors laccForAndroidLibraryAccessors = new AndroidLibraryAccessors(owner);
    private final AndroidxLibraryAccessors laccForAndroidxLibraryAccessors = new AndroidxLibraryAccessors(owner);
    private final CoilLibraryAccessors laccForCoilLibraryAccessors = new CoilLibraryAccessors(owner);
    private final DaggerLibraryAccessors laccForDaggerLibraryAccessors = new DaggerLibraryAccessors(owner);
    private final DesugarLibraryAccessors laccForDesugarLibraryAccessors = new DesugarLibraryAccessors(owner);
    private final DetektLibraryAccessors laccForDetektLibraryAccessors = new DetektLibraryAccessors(owner);
    private final JavaxLibraryAccessors laccForJavaxLibraryAccessors = new JavaxLibraryAccessors(owner);
    private final KodeLibraryAccessors laccForKodeLibraryAccessors = new KodeLibraryAccessors(owner);
    private final KotlinLibraryAccessors laccForKotlinLibraryAccessors = new KotlinLibraryAccessors(owner);
    private final KotlinxLibraryAccessors laccForKotlinxLibraryAccessors = new KotlinxLibraryAccessors(owner);
    private final RetrofitLibraryAccessors laccForRetrofitLibraryAccessors = new RetrofitLibraryAccessors(owner);
    private final SpotlessLibraryAccessors laccForSpotlessLibraryAccessors = new SpotlessLibraryAccessors(owner);
    private final TwitterLibraryAccessors laccForTwitterLibraryAccessors = new TwitterLibraryAccessors(owner);
    private final VersionAccessors vaccForVersionAccessors = new VersionAccessors(providers, config);
    private final BundleAccessors baccForBundleAccessors = new BundleAccessors(providers, config);
    private final PluginAccessors paccForPluginAccessors = new PluginAccessors(providers, config);

    @Inject
    public LibrariesForLibs(DefaultVersionCatalog config, ProviderFactory providers) {
        super(config, providers);
    }

        /**
         * Creates a dependency provider for junit (junit:junit)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJunit() { return create("junit"); }

        /**
         * Creates a dependency provider for mockk (io.mockk:mockk)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getMockk() { return create("mockk"); }

        /**
         * Creates a dependency provider for okhttp (com.squareup.okhttp3:okhttp)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getOkhttp() { return create("okhttp"); }

    /**
     * Returns the group of libraries at accompanist
     */
    public AccompanistLibraryAccessors getAccompanist() { return laccForAccompanistLibraryAccessors; }

    /**
     * Returns the group of libraries at android
     */
    public AndroidLibraryAccessors getAndroid() { return laccForAndroidLibraryAccessors; }

    /**
     * Returns the group of libraries at androidx
     */
    public AndroidxLibraryAccessors getAndroidx() { return laccForAndroidxLibraryAccessors; }

    /**
     * Returns the group of libraries at coil
     */
    public CoilLibraryAccessors getCoil() { return laccForCoilLibraryAccessors; }

    /**
     * Returns the group of libraries at dagger
     */
    public DaggerLibraryAccessors getDagger() { return laccForDaggerLibraryAccessors; }

    /**
     * Returns the group of libraries at desugar
     */
    public DesugarLibraryAccessors getDesugar() { return laccForDesugarLibraryAccessors; }

    /**
     * Returns the group of libraries at detekt
     */
    public DetektLibraryAccessors getDetekt() { return laccForDetektLibraryAccessors; }

    /**
     * Returns the group of libraries at javax
     */
    public JavaxLibraryAccessors getJavax() { return laccForJavaxLibraryAccessors; }

    /**
     * Returns the group of libraries at kode
     */
    public KodeLibraryAccessors getKode() { return laccForKodeLibraryAccessors; }

    /**
     * Returns the group of libraries at kotlin
     */
    public KotlinLibraryAccessors getKotlin() { return laccForKotlinLibraryAccessors; }

    /**
     * Returns the group of libraries at kotlinx
     */
    public KotlinxLibraryAccessors getKotlinx() { return laccForKotlinxLibraryAccessors; }

    /**
     * Returns the group of libraries at retrofit
     */
    public RetrofitLibraryAccessors getRetrofit() { return laccForRetrofitLibraryAccessors; }

    /**
     * Returns the group of libraries at spotless
     */
    public SpotlessLibraryAccessors getSpotless() { return laccForSpotlessLibraryAccessors; }

    /**
     * Returns the group of libraries at twitter
     */
    public TwitterLibraryAccessors getTwitter() { return laccForTwitterLibraryAccessors; }

    /**
     * Returns the group of versions at versions
     */
    public VersionAccessors getVersions() { return vaccForVersionAccessors; }

    /**
     * Returns the group of bundles at bundles
     */
    public BundleAccessors getBundles() { return baccForBundleAccessors; }

    /**
     * Returns the group of plugins at plugins
     */
    public PluginAccessors getPlugins() { return paccForPluginAccessors; }

    public static class AccompanistLibraryAccessors extends SubDependencyFactory {
        private final AccompanistPagerLibraryAccessors laccForAccompanistPagerLibraryAccessors = new AccompanistPagerLibraryAccessors(owner);
        private final AccompanistPlaceholderLibraryAccessors laccForAccompanistPlaceholderLibraryAccessors = new AccompanistPlaceholderLibraryAccessors(owner);

        public AccompanistLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for swiperefresh (com.google.accompanist:accompanist-swiperefresh)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getSwiperefresh() { return create("accompanist.swiperefresh"); }

            /**
             * Creates a dependency provider for systemuicontroller (com.google.accompanist:accompanist-systemuicontroller)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getSystemuicontroller() { return create("accompanist.systemuicontroller"); }

        /**
         * Returns the group of libraries at accompanist.pager
         */
        public AccompanistPagerLibraryAccessors getPager() { return laccForAccompanistPagerLibraryAccessors; }

        /**
         * Returns the group of libraries at accompanist.placeholder
         */
        public AccompanistPlaceholderLibraryAccessors getPlaceholder() { return laccForAccompanistPlaceholderLibraryAccessors; }

    }

    public static class AccompanistPagerLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public AccompanistPagerLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for pager (com.google.accompanist:accompanist-pager)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> asProvider() { return create("accompanist.pager"); }

            /**
             * Creates a dependency provider for indicators (com.google.accompanist:accompanist-pager-indicators)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getIndicators() { return create("accompanist.pager.indicators"); }

    }

    public static class AccompanistPlaceholderLibraryAccessors extends SubDependencyFactory {

        public AccompanistPlaceholderLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for material (com.google.accompanist:accompanist-placeholder-material)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getMaterial() { return create("accompanist.placeholder.material"); }

    }

    public static class AndroidLibraryAccessors extends SubDependencyFactory {
        private final AndroidGradleLibraryAccessors laccForAndroidGradleLibraryAccessors = new AndroidGradleLibraryAccessors(owner);

        public AndroidLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at android.gradle
         */
        public AndroidGradleLibraryAccessors getGradle() { return laccForAndroidGradleLibraryAccessors; }

    }

    public static class AndroidGradleLibraryAccessors extends SubDependencyFactory {

        public AndroidGradleLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for plugin (com.android.tools.build:gradle)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getPlugin() { return create("android.gradle.plugin"); }

    }

    public static class AndroidxLibraryAccessors extends SubDependencyFactory {
        private final AndroidxActivityLibraryAccessors laccForAndroidxActivityLibraryAccessors = new AndroidxActivityLibraryAccessors(owner);
        private final AndroidxBenchmarkLibraryAccessors laccForAndroidxBenchmarkLibraryAccessors = new AndroidxBenchmarkLibraryAccessors(owner);
        private final AndroidxComposeLibraryAccessors laccForAndroidxComposeLibraryAccessors = new AndroidxComposeLibraryAccessors(owner);
        private final AndroidxCoreLibraryAccessors laccForAndroidxCoreLibraryAccessors = new AndroidxCoreLibraryAccessors(owner);
        private final AndroidxDatastoreLibraryAccessors laccForAndroidxDatastoreLibraryAccessors = new AndroidxDatastoreLibraryAccessors(owner);
        private final AndroidxHiltLibraryAccessors laccForAndroidxHiltLibraryAccessors = new AndroidxHiltLibraryAccessors(owner);
        private final AndroidxLifecycleLibraryAccessors laccForAndroidxLifecycleLibraryAccessors = new AndroidxLifecycleLibraryAccessors(owner);
        private final AndroidxNavigationLibraryAccessors laccForAndroidxNavigationLibraryAccessors = new AndroidxNavigationLibraryAccessors(owner);
        private final AndroidxPagingLibraryAccessors laccForAndroidxPagingLibraryAccessors = new AndroidxPagingLibraryAccessors(owner);
        private final AndroidxRoomLibraryAccessors laccForAndroidxRoomLibraryAccessors = new AndroidxRoomLibraryAccessors(owner);
        private final AndroidxTestLibraryAccessors laccForAndroidxTestLibraryAccessors = new AndroidxTestLibraryAccessors(owner);

        public AndroidxLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for annotation (androidx.annotation:annotation)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getAnnotation() { return create("androidx.annotation"); }

            /**
             * Creates a dependency provider for profileinstaller (androidx.profileinstaller:profileinstaller)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getProfileinstaller() { return create("androidx.profileinstaller"); }

        /**
         * Returns the group of libraries at androidx.activity
         */
        public AndroidxActivityLibraryAccessors getActivity() { return laccForAndroidxActivityLibraryAccessors; }

        /**
         * Returns the group of libraries at androidx.benchmark
         */
        public AndroidxBenchmarkLibraryAccessors getBenchmark() { return laccForAndroidxBenchmarkLibraryAccessors; }

        /**
         * Returns the group of libraries at androidx.compose
         */
        public AndroidxComposeLibraryAccessors getCompose() { return laccForAndroidxComposeLibraryAccessors; }

        /**
         * Returns the group of libraries at androidx.core
         */
        public AndroidxCoreLibraryAccessors getCore() { return laccForAndroidxCoreLibraryAccessors; }

        /**
         * Returns the group of libraries at androidx.datastore
         */
        public AndroidxDatastoreLibraryAccessors getDatastore() { return laccForAndroidxDatastoreLibraryAccessors; }

        /**
         * Returns the group of libraries at androidx.hilt
         */
        public AndroidxHiltLibraryAccessors getHilt() { return laccForAndroidxHiltLibraryAccessors; }

        /**
         * Returns the group of libraries at androidx.lifecycle
         */
        public AndroidxLifecycleLibraryAccessors getLifecycle() { return laccForAndroidxLifecycleLibraryAccessors; }

        /**
         * Returns the group of libraries at androidx.navigation
         */
        public AndroidxNavigationLibraryAccessors getNavigation() { return laccForAndroidxNavigationLibraryAccessors; }

        /**
         * Returns the group of libraries at androidx.paging
         */
        public AndroidxPagingLibraryAccessors getPaging() { return laccForAndroidxPagingLibraryAccessors; }

        /**
         * Returns the group of libraries at androidx.room
         */
        public AndroidxRoomLibraryAccessors getRoom() { return laccForAndroidxRoomLibraryAccessors; }

        /**
         * Returns the group of libraries at androidx.test
         */
        public AndroidxTestLibraryAccessors getTest() { return laccForAndroidxTestLibraryAccessors; }

    }

    public static class AndroidxActivityLibraryAccessors extends SubDependencyFactory {

        public AndroidxActivityLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for compose (androidx.activity:activity-compose)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCompose() { return create("androidx.activity.compose"); }

    }

    public static class AndroidxBenchmarkLibraryAccessors extends SubDependencyFactory {
        private final AndroidxBenchmarkMacroLibraryAccessors laccForAndroidxBenchmarkMacroLibraryAccessors = new AndroidxBenchmarkMacroLibraryAccessors(owner);

        public AndroidxBenchmarkLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at androidx.benchmark.macro
         */
        public AndroidxBenchmarkMacroLibraryAccessors getMacro() { return laccForAndroidxBenchmarkMacroLibraryAccessors; }

    }

    public static class AndroidxBenchmarkMacroLibraryAccessors extends SubDependencyFactory {

        public AndroidxBenchmarkMacroLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for junit4 (androidx.benchmark:benchmark-macro-junit4)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getJunit4() { return create("androidx.benchmark.macro.junit4"); }

    }

    public static class AndroidxComposeLibraryAccessors extends SubDependencyFactory {
        private final AndroidxComposeUiLibraryAccessors laccForAndroidxComposeUiLibraryAccessors = new AndroidxComposeUiLibraryAccessors(owner);

        public AndroidxComposeLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for bom (androidx.compose:compose-bom)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getBom() { return create("androidx.compose.bom"); }

            /**
             * Creates a dependency provider for material3 (androidx.compose.material3:material3)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getMaterial3() { return create("androidx.compose.material3"); }

        /**
         * Returns the group of libraries at androidx.compose.ui
         */
        public AndroidxComposeUiLibraryAccessors getUi() { return laccForAndroidxComposeUiLibraryAccessors; }

    }

    public static class AndroidxComposeUiLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {
        private final AndroidxComposeUiTestLibraryAccessors laccForAndroidxComposeUiTestLibraryAccessors = new AndroidxComposeUiTestLibraryAccessors(owner);
        private final AndroidxComposeUiToolingLibraryAccessors laccForAndroidxComposeUiToolingLibraryAccessors = new AndroidxComposeUiToolingLibraryAccessors(owner);

        public AndroidxComposeUiLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for ui (androidx.compose.ui:ui)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> asProvider() { return create("androidx.compose.ui"); }

            /**
             * Creates a dependency provider for util (androidx.compose.ui:ui-util)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getUtil() { return create("androidx.compose.ui.util"); }

        /**
         * Returns the group of libraries at androidx.compose.ui.test
         */
        public AndroidxComposeUiTestLibraryAccessors getTest() { return laccForAndroidxComposeUiTestLibraryAccessors; }

        /**
         * Returns the group of libraries at androidx.compose.ui.tooling
         */
        public AndroidxComposeUiToolingLibraryAccessors getTooling() { return laccForAndroidxComposeUiToolingLibraryAccessors; }

    }

    public static class AndroidxComposeUiTestLibraryAccessors extends SubDependencyFactory {

        public AndroidxComposeUiTestLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for junit4 (androidx.compose.ui:ui-test-junit4)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getJunit4() { return create("androidx.compose.ui.test.junit4"); }

            /**
             * Creates a dependency provider for manifest (androidx.compose.ui:ui-test-manifest)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getManifest() { return create("androidx.compose.ui.test.manifest"); }

    }

    public static class AndroidxComposeUiToolingLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public AndroidxComposeUiToolingLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for tooling (androidx.compose.ui:ui-tooling)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> asProvider() { return create("androidx.compose.ui.tooling"); }

            /**
             * Creates a dependency provider for preview (androidx.compose.ui:ui-tooling-preview)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getPreview() { return create("androidx.compose.ui.tooling.preview"); }

    }

    public static class AndroidxCoreLibraryAccessors extends SubDependencyFactory {

        public AndroidxCoreLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for ktx (androidx.core:core-ktx)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getKtx() { return create("androidx.core.ktx"); }

            /**
             * Creates a dependency provider for splashscreen (androidx.core:core-splashscreen)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getSplashscreen() { return create("androidx.core.splashscreen"); }

    }

    public static class AndroidxDatastoreLibraryAccessors extends SubDependencyFactory {

        public AndroidxDatastoreLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for preferences (androidx.datastore:datastore-preferences)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getPreferences() { return create("androidx.datastore.preferences"); }

    }

    public static class AndroidxHiltLibraryAccessors extends SubDependencyFactory {
        private final AndroidxHiltNavigationLibraryAccessors laccForAndroidxHiltNavigationLibraryAccessors = new AndroidxHiltNavigationLibraryAccessors(owner);

        public AndroidxHiltLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at androidx.hilt.navigation
         */
        public AndroidxHiltNavigationLibraryAccessors getNavigation() { return laccForAndroidxHiltNavigationLibraryAccessors; }

    }

    public static class AndroidxHiltNavigationLibraryAccessors extends SubDependencyFactory {

        public AndroidxHiltNavigationLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for compose (androidx.hilt:hilt-navigation-compose)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCompose() { return create("androidx.hilt.navigation.compose"); }

    }

    public static class AndroidxLifecycleLibraryAccessors extends SubDependencyFactory {
        private final AndroidxLifecycleRuntimeLibraryAccessors laccForAndroidxLifecycleRuntimeLibraryAccessors = new AndroidxLifecycleRuntimeLibraryAccessors(owner);
        private final AndroidxLifecycleViewmodelLibraryAccessors laccForAndroidxLifecycleViewmodelLibraryAccessors = new AndroidxLifecycleViewmodelLibraryAccessors(owner);

        public AndroidxLifecycleLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at androidx.lifecycle.runtime
         */
        public AndroidxLifecycleRuntimeLibraryAccessors getRuntime() { return laccForAndroidxLifecycleRuntimeLibraryAccessors; }

        /**
         * Returns the group of libraries at androidx.lifecycle.viewmodel
         */
        public AndroidxLifecycleViewmodelLibraryAccessors getViewmodel() { return laccForAndroidxLifecycleViewmodelLibraryAccessors; }

    }

    public static class AndroidxLifecycleRuntimeLibraryAccessors extends SubDependencyFactory {

        public AndroidxLifecycleRuntimeLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for compose (androidx.lifecycle:lifecycle-runtime-compose)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCompose() { return create("androidx.lifecycle.runtime.compose"); }

    }

    public static class AndroidxLifecycleViewmodelLibraryAccessors extends SubDependencyFactory {

        public AndroidxLifecycleViewmodelLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for compose (androidx.lifecycle:lifecycle-viewmodel-compose)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCompose() { return create("androidx.lifecycle.viewmodel.compose"); }

    }

    public static class AndroidxNavigationLibraryAccessors extends SubDependencyFactory {

        public AndroidxNavigationLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for compose (androidx.navigation:navigation-compose)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCompose() { return create("androidx.navigation.compose"); }

    }

    public static class AndroidxPagingLibraryAccessors extends SubDependencyFactory {

        public AndroidxPagingLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for common (androidx.paging:paging-common)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCommon() { return create("androidx.paging.common"); }

            /**
             * Creates a dependency provider for compose (androidx.paging:paging-compose)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCompose() { return create("androidx.paging.compose"); }

            /**
             * Creates a dependency provider for runtime (androidx.paging:paging-runtime)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getRuntime() { return create("androidx.paging.runtime"); }

    }

    public static class AndroidxRoomLibraryAccessors extends SubDependencyFactory {

        public AndroidxRoomLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for common (androidx.room:room-common)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCommon() { return create("androidx.room.common"); }

            /**
             * Creates a dependency provider for compiler (androidx.room:room-compiler)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCompiler() { return create("androidx.room.compiler"); }

            /**
             * Creates a dependency provider for ktx (androidx.room:room-ktx)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getKtx() { return create("androidx.room.ktx"); }

            /**
             * Creates a dependency provider for paging (androidx.room:room-paging)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getPaging() { return create("androidx.room.paging"); }

            /**
             * Creates a dependency provider for runtime (androidx.room:room-runtime)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getRuntime() { return create("androidx.room.runtime"); }

    }

    public static class AndroidxTestLibraryAccessors extends SubDependencyFactory {
        private final AndroidxTestEspressoLibraryAccessors laccForAndroidxTestEspressoLibraryAccessors = new AndroidxTestEspressoLibraryAccessors(owner);
        private final AndroidxTestExtLibraryAccessors laccForAndroidxTestExtLibraryAccessors = new AndroidxTestExtLibraryAccessors(owner);

        public AndroidxTestLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for uiautomator (androidx.test.uiautomator:uiautomator)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getUiautomator() { return create("androidx.test.uiautomator"); }

        /**
         * Returns the group of libraries at androidx.test.espresso
         */
        public AndroidxTestEspressoLibraryAccessors getEspresso() { return laccForAndroidxTestEspressoLibraryAccessors; }

        /**
         * Returns the group of libraries at androidx.test.ext
         */
        public AndroidxTestExtLibraryAccessors getExt() { return laccForAndroidxTestExtLibraryAccessors; }

    }

    public static class AndroidxTestEspressoLibraryAccessors extends SubDependencyFactory {

        public AndroidxTestEspressoLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for core (androidx.test.espresso:espresso-core)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCore() { return create("androidx.test.espresso.core"); }

    }

    public static class AndroidxTestExtLibraryAccessors extends SubDependencyFactory {

        public AndroidxTestExtLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for junit (androidx.test.ext:junit)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getJunit() { return create("androidx.test.ext.junit"); }

    }

    public static class CoilLibraryAccessors extends SubDependencyFactory {

        public CoilLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for compose (io.coil-kt:coil-compose)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCompose() { return create("coil.compose"); }

    }

    public static class DaggerLibraryAccessors extends SubDependencyFactory {
        private final DaggerHiltLibraryAccessors laccForDaggerHiltLibraryAccessors = new DaggerHiltLibraryAccessors(owner);

        public DaggerLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at dagger.hilt
         */
        public DaggerHiltLibraryAccessors getHilt() { return laccForDaggerHiltLibraryAccessors; }

    }

    public static class DaggerHiltLibraryAccessors extends SubDependencyFactory {

        public DaggerHiltLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for android (com.google.dagger:hilt-android)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getAndroid() { return create("dagger.hilt.android"); }

            /**
             * Creates a dependency provider for compiler (com.google.dagger:hilt-compiler)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCompiler() { return create("dagger.hilt.compiler"); }

            /**
             * Creates a dependency provider for core (com.google.dagger:hilt-core)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCore() { return create("dagger.hilt.core"); }

    }

    public static class DesugarLibraryAccessors extends SubDependencyFactory {
        private final DesugarJdkLibraryAccessors laccForDesugarJdkLibraryAccessors = new DesugarJdkLibraryAccessors(owner);

        public DesugarLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at desugar.jdk
         */
        public DesugarJdkLibraryAccessors getJdk() { return laccForDesugarJdkLibraryAccessors; }

    }

    public static class DesugarJdkLibraryAccessors extends SubDependencyFactory {

        public DesugarJdkLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for libs (com.android.tools:desugar_jdk_libs)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getLibs() { return create("desugar.jdk.libs"); }

    }

    public static class DetektLibraryAccessors extends SubDependencyFactory {
        private final DetektGradleLibraryAccessors laccForDetektGradleLibraryAccessors = new DetektGradleLibraryAccessors(owner);

        public DetektLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for formatting (io.gitlab.arturbosch.detekt:detekt-formatting)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getFormatting() { return create("detekt.formatting"); }

        /**
         * Returns the group of libraries at detekt.gradle
         */
        public DetektGradleLibraryAccessors getGradle() { return laccForDetektGradleLibraryAccessors; }

    }

    public static class DetektGradleLibraryAccessors extends SubDependencyFactory {

        public DetektGradleLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for plugin (io.gitlab.arturbosch.detekt:detekt-gradle-plugin)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getPlugin() { return create("detekt.gradle.plugin"); }

    }

    public static class JavaxLibraryAccessors extends SubDependencyFactory {

        public JavaxLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for inject (javax.inject:javax.inject)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getInject() { return create("javax.inject"); }

    }

    public static class KodeLibraryAccessors extends SubDependencyFactory {
        private final KodeDetektLibraryAccessors laccForKodeDetektLibraryAccessors = new KodeDetektLibraryAccessors(owner);

        public KodeLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at kode.detekt
         */
        public KodeDetektLibraryAccessors getDetekt() { return laccForKodeDetektLibraryAccessors; }

    }

    public static class KodeDetektLibraryAccessors extends SubDependencyFactory {
        private final KodeDetektRulesLibraryAccessors laccForKodeDetektRulesLibraryAccessors = new KodeDetektRulesLibraryAccessors(owner);

        public KodeDetektLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at kode.detekt.rules
         */
        public KodeDetektRulesLibraryAccessors getRules() { return laccForKodeDetektRulesLibraryAccessors; }

    }

    public static class KodeDetektRulesLibraryAccessors extends SubDependencyFactory {

        public KodeDetektRulesLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for compose (ru.kode:detekt-rules-compose)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCompose() { return create("kode.detekt.rules.compose"); }

    }

    public static class KotlinLibraryAccessors extends SubDependencyFactory {
        private final KotlinGradleLibraryAccessors laccForKotlinGradleLibraryAccessors = new KotlinGradleLibraryAccessors(owner);

        public KotlinLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at kotlin.gradle
         */
        public KotlinGradleLibraryAccessors getGradle() { return laccForKotlinGradleLibraryAccessors; }

    }

    public static class KotlinGradleLibraryAccessors extends SubDependencyFactory {

        public KotlinGradleLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for plugin (org.jetbrains.kotlin:kotlin-gradle-plugin)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getPlugin() { return create("kotlin.gradle.plugin"); }

    }

    public static class KotlinxLibraryAccessors extends SubDependencyFactory {
        private final KotlinxCoroutinesLibraryAccessors laccForKotlinxCoroutinesLibraryAccessors = new KotlinxCoroutinesLibraryAccessors(owner);
        private final KotlinxSerializationLibraryAccessors laccForKotlinxSerializationLibraryAccessors = new KotlinxSerializationLibraryAccessors(owner);

        public KotlinxLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for datetime (org.jetbrains.kotlinx:kotlinx-datetime)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getDatetime() { return create("kotlinx.datetime"); }

        /**
         * Returns the group of libraries at kotlinx.coroutines
         */
        public KotlinxCoroutinesLibraryAccessors getCoroutines() { return laccForKotlinxCoroutinesLibraryAccessors; }

        /**
         * Returns the group of libraries at kotlinx.serialization
         */
        public KotlinxSerializationLibraryAccessors getSerialization() { return laccForKotlinxSerializationLibraryAccessors; }

    }

    public static class KotlinxCoroutinesLibraryAccessors extends SubDependencyFactory {

        public KotlinxCoroutinesLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for android (org.jetbrains.kotlinx:kotlinx-coroutines-android)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getAndroid() { return create("kotlinx.coroutines.android"); }

            /**
             * Creates a dependency provider for core (org.jetbrains.kotlinx:kotlinx-coroutines-core)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCore() { return create("kotlinx.coroutines.core"); }

    }

    public static class KotlinxSerializationLibraryAccessors extends SubDependencyFactory {

        public KotlinxSerializationLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for json (org.jetbrains.kotlinx:kotlinx-serialization-json)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getJson() { return create("kotlinx.serialization.json"); }

    }

    public static class RetrofitLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {
        private final RetrofitKotlinxLibraryAccessors laccForRetrofitKotlinxLibraryAccessors = new RetrofitKotlinxLibraryAccessors(owner);

        public RetrofitLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for retrofit (com.squareup.retrofit2:retrofit)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> asProvider() { return create("retrofit"); }

        /**
         * Returns the group of libraries at retrofit.kotlinx
         */
        public RetrofitKotlinxLibraryAccessors getKotlinx() { return laccForRetrofitKotlinxLibraryAccessors; }

    }

    public static class RetrofitKotlinxLibraryAccessors extends SubDependencyFactory {
        private final RetrofitKotlinxSerializationLibraryAccessors laccForRetrofitKotlinxSerializationLibraryAccessors = new RetrofitKotlinxSerializationLibraryAccessors(owner);

        public RetrofitKotlinxLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at retrofit.kotlinx.serialization
         */
        public RetrofitKotlinxSerializationLibraryAccessors getSerialization() { return laccForRetrofitKotlinxSerializationLibraryAccessors; }

    }

    public static class RetrofitKotlinxSerializationLibraryAccessors extends SubDependencyFactory {

        public RetrofitKotlinxSerializationLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for converter (com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getConverter() { return create("retrofit.kotlinx.serialization.converter"); }

    }

    public static class SpotlessLibraryAccessors extends SubDependencyFactory {
        private final SpotlessGradleLibraryAccessors laccForSpotlessGradleLibraryAccessors = new SpotlessGradleLibraryAccessors(owner);

        public SpotlessLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at spotless.gradle
         */
        public SpotlessGradleLibraryAccessors getGradle() { return laccForSpotlessGradleLibraryAccessors; }

    }

    public static class SpotlessGradleLibraryAccessors extends SubDependencyFactory {

        public SpotlessGradleLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for plugin (com.diffplug.spotless:spotless-plugin-gradle)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getPlugin() { return create("spotless.gradle.plugin"); }

    }

    public static class TwitterLibraryAccessors extends SubDependencyFactory {
        private final TwitterComposeLibraryAccessors laccForTwitterComposeLibraryAccessors = new TwitterComposeLibraryAccessors(owner);

        public TwitterLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at twitter.compose
         */
        public TwitterComposeLibraryAccessors getCompose() { return laccForTwitterComposeLibraryAccessors; }

    }

    public static class TwitterComposeLibraryAccessors extends SubDependencyFactory {
        private final TwitterComposeRulesLibraryAccessors laccForTwitterComposeRulesLibraryAccessors = new TwitterComposeRulesLibraryAccessors(owner);

        public TwitterComposeLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at twitter.compose.rules
         */
        public TwitterComposeRulesLibraryAccessors getRules() { return laccForTwitterComposeRulesLibraryAccessors; }

    }

    public static class TwitterComposeRulesLibraryAccessors extends SubDependencyFactory {

        public TwitterComposeRulesLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for detekt (com.twitter.compose.rules:detekt)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getDetekt() { return create("twitter.compose.rules.detekt"); }

    }

    public static class VersionAccessors extends VersionFactory  {

        private final AndroidVersionAccessors vaccForAndroidVersionAccessors = new AndroidVersionAccessors(providers, config);
        private final AndroidxVersionAccessors vaccForAndroidxVersionAccessors = new AndroidxVersionAccessors(providers, config);
        private final DesugarVersionAccessors vaccForDesugarVersionAccessors = new DesugarVersionAccessors(providers, config);
        private final JavaxVersionAccessors vaccForJavaxVersionAccessors = new JavaxVersionAccessors(providers, config);
        private final KodeVersionAccessors vaccForKodeVersionAccessors = new KodeVersionAccessors(providers, config);
        private final KotlinxVersionAccessors vaccForKotlinxVersionAccessors = new KotlinxVersionAccessors(providers, config);
        private final RetrofitVersionAccessors vaccForRetrofitVersionAccessors = new RetrofitVersionAccessors(providers, config);
        private final TwitterVersionAccessors vaccForTwitterVersionAccessors = new TwitterVersionAccessors(providers, config);
        public VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: accompanist (0.28.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getAccompanist() { return getVersion("accompanist"); }

            /**
             * Returns the version associated to this alias: coil (2.2.2)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getCoil() { return getVersion("coil"); }

            /**
             * Returns the version associated to this alias: dagger (2.45)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getDagger() { return getVersion("dagger"); }

            /**
             * Returns the version associated to this alias: detekt (1.22.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getDetekt() { return getVersion("detekt"); }

            /**
             * Returns the version associated to this alias: junit (4.13.2)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getJunit() { return getVersion("junit"); }

            /**
             * Returns the version associated to this alias: kotlin (1.7.20)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getKotlin() { return getVersion("kotlin"); }

            /**
             * Returns the version associated to this alias: ksp (1.7.20-1.0.8)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getKsp() { return getVersion("ksp"); }

            /**
             * Returns the version associated to this alias: mockk (1.13.4)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getMockk() { return getVersion("mockk"); }

            /**
             * Returns the version associated to this alias: okhttp (4.10.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getOkhttp() { return getVersion("okhttp"); }

            /**
             * Returns the version associated to this alias: spotless (6.14.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getSpotless() { return getVersion("spotless"); }

        /**
         * Returns the group of versions at versions.android
         */
        public AndroidVersionAccessors getAndroid() { return vaccForAndroidVersionAccessors; }

        /**
         * Returns the group of versions at versions.androidx
         */
        public AndroidxVersionAccessors getAndroidx() { return vaccForAndroidxVersionAccessors; }

        /**
         * Returns the group of versions at versions.desugar
         */
        public DesugarVersionAccessors getDesugar() { return vaccForDesugarVersionAccessors; }

        /**
         * Returns the group of versions at versions.javax
         */
        public JavaxVersionAccessors getJavax() { return vaccForJavaxVersionAccessors; }

        /**
         * Returns the group of versions at versions.kode
         */
        public KodeVersionAccessors getKode() { return vaccForKodeVersionAccessors; }

        /**
         * Returns the group of versions at versions.kotlinx
         */
        public KotlinxVersionAccessors getKotlinx() { return vaccForKotlinxVersionAccessors; }

        /**
         * Returns the group of versions at versions.retrofit
         */
        public RetrofitVersionAccessors getRetrofit() { return vaccForRetrofitVersionAccessors; }

        /**
         * Returns the group of versions at versions.twitter
         */
        public TwitterVersionAccessors getTwitter() { return vaccForTwitterVersionAccessors; }

    }

    public static class AndroidVersionAccessors extends VersionFactory  {

        private final AndroidGradleVersionAccessors vaccForAndroidGradleVersionAccessors = new AndroidGradleVersionAccessors(providers, config);
        public AndroidVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: android.compileSdk (33)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getCompileSdk() { return getVersion("android.compileSdk"); }

            /**
             * Returns the version associated to this alias: android.minSdk (26)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getMinSdk() { return getVersion("android.minSdk"); }

            /**
             * Returns the version associated to this alias: android.targetSdk (33)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getTargetSdk() { return getVersion("android.targetSdk"); }

        /**
         * Returns the group of versions at versions.android.gradle
         */
        public AndroidGradleVersionAccessors getGradle() { return vaccForAndroidGradleVersionAccessors; }

    }

    public static class AndroidGradleVersionAccessors extends VersionFactory  {

        public AndroidGradleVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: android.gradle.plugin (7.3.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getPlugin() { return getVersion("android.gradle.plugin"); }

    }

    public static class AndroidxVersionAccessors extends VersionFactory  {

        private final AndroidxComposeVersionAccessors vaccForAndroidxComposeVersionAccessors = new AndroidxComposeVersionAccessors(providers, config);
        private final AndroidxCoreVersionAccessors vaccForAndroidxCoreVersionAccessors = new AndroidxCoreVersionAccessors(providers, config);
        private final AndroidxPagingVersionAccessors vaccForAndroidxPagingVersionAccessors = new AndroidxPagingVersionAccessors(providers, config);
        private final AndroidxTestVersionAccessors vaccForAndroidxTestVersionAccessors = new AndroidxTestVersionAccessors(providers, config);
        public AndroidxVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: androidx.activity (1.6.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getActivity() { return getVersion("androidx.activity"); }

            /**
             * Returns the version associated to this alias: androidx.annotation (1.5.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getAnnotation() { return getVersion("androidx.annotation"); }

            /**
             * Returns the version associated to this alias: androidx.benchmark (1.2.0-alpha10)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getBenchmark() { return getVersion("androidx.benchmark"); }

            /**
             * Returns the version associated to this alias: androidx.datastore (1.0.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getDatastore() { return getVersion("androidx.datastore"); }

            /**
             * Returns the version associated to this alias: androidx.hilt (1.0.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getHilt() { return getVersion("androidx.hilt"); }

            /**
             * Returns the version associated to this alias: androidx.lifecycle (2.6.0-alpha03)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getLifecycle() { return getVersion("androidx.lifecycle"); }

            /**
             * Returns the version associated to this alias: androidx.navigation (2.5.3)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getNavigation() { return getVersion("androidx.navigation"); }

            /**
             * Returns the version associated to this alias: androidx.profileinstaller (1.2.2)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getProfileinstaller() { return getVersion("androidx.profileinstaller"); }

            /**
             * Returns the version associated to this alias: androidx.room (2.5.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getRoom() { return getVersion("androidx.room"); }

        /**
         * Returns the group of versions at versions.androidx.compose
         */
        public AndroidxComposeVersionAccessors getCompose() { return vaccForAndroidxComposeVersionAccessors; }

        /**
         * Returns the group of versions at versions.androidx.core
         */
        public AndroidxCoreVersionAccessors getCore() { return vaccForAndroidxCoreVersionAccessors; }

        /**
         * Returns the group of versions at versions.androidx.paging
         */
        public AndroidxPagingVersionAccessors getPaging() { return vaccForAndroidxPagingVersionAccessors; }

        /**
         * Returns the group of versions at versions.androidx.test
         */
        public AndroidxTestVersionAccessors getTest() { return vaccForAndroidxTestVersionAccessors; }

    }

    public static class AndroidxComposeVersionAccessors extends VersionFactory  {

        public AndroidxComposeVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: androidx.compose.bom (2023.01.00)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getBom() { return getVersion("androidx.compose.bom"); }

            /**
             * Returns the version associated to this alias: androidx.compose.compiler (1.3.2)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getCompiler() { return getVersion("androidx.compose.compiler"); }

    }

    public static class AndroidxCoreVersionAccessors extends VersionFactory  implements VersionNotationSupplier {

        public AndroidxCoreVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the version associated to this alias: androidx.core (1.9.0)
         * If the version is a rich version and that its not expressible as a
         * single version string, then an empty string is returned.
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> asProvider() { return getVersion("androidx.core"); }

            /**
             * Returns the version associated to this alias: androidx.core.splashscreen (1.0.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getSplashscreen() { return getVersion("androidx.core.splashscreen"); }

    }

    public static class AndroidxPagingVersionAccessors extends VersionFactory  implements VersionNotationSupplier {

        public AndroidxPagingVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the version associated to this alias: androidx.paging (3.1.1)
         * If the version is a rich version and that its not expressible as a
         * single version string, then an empty string is returned.
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> asProvider() { return getVersion("androidx.paging"); }

            /**
             * Returns the version associated to this alias: androidx.paging.compose (1.0.0-alpha17)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getCompose() { return getVersion("androidx.paging.compose"); }

    }

    public static class AndroidxTestVersionAccessors extends VersionFactory  {

        public AndroidxTestVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: androidx.test.espresso (3.5.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getEspresso() { return getVersion("androidx.test.espresso"); }

            /**
             * Returns the version associated to this alias: androidx.test.ext (1.1.5)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getExt() { return getVersion("androidx.test.ext"); }

            /**
             * Returns the version associated to this alias: androidx.test.uiautomator (2.2.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getUiautomator() { return getVersion("androidx.test.uiautomator"); }

    }

    public static class DesugarVersionAccessors extends VersionFactory  {

        private final DesugarJdkVersionAccessors vaccForDesugarJdkVersionAccessors = new DesugarJdkVersionAccessors(providers, config);
        public DesugarVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.desugar.jdk
         */
        public DesugarJdkVersionAccessors getJdk() { return vaccForDesugarJdkVersionAccessors; }

    }

    public static class DesugarJdkVersionAccessors extends VersionFactory  {

        public DesugarJdkVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: desugar.jdk.libs (1.2.2)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getLibs() { return getVersion("desugar.jdk.libs"); }

    }

    public static class JavaxVersionAccessors extends VersionFactory  {

        public JavaxVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: javax.inject (1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getInject() { return getVersion("javax.inject"); }

    }

    public static class KodeVersionAccessors extends VersionFactory  {

        private final KodeDetektVersionAccessors vaccForKodeDetektVersionAccessors = new KodeDetektVersionAccessors(providers, config);
        public KodeVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.kode.detekt
         */
        public KodeDetektVersionAccessors getDetekt() { return vaccForKodeDetektVersionAccessors; }

    }

    public static class KodeDetektVersionAccessors extends VersionFactory  {

        private final KodeDetektRulesVersionAccessors vaccForKodeDetektRulesVersionAccessors = new KodeDetektRulesVersionAccessors(providers, config);
        public KodeDetektVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.kode.detekt.rules
         */
        public KodeDetektRulesVersionAccessors getRules() { return vaccForKodeDetektRulesVersionAccessors; }

    }

    public static class KodeDetektRulesVersionAccessors extends VersionFactory  {

        public KodeDetektRulesVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: kode.detekt.rules.compose (1.2.2)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getCompose() { return getVersion("kode.detekt.rules.compose"); }

    }

    public static class KotlinxVersionAccessors extends VersionFactory  {

        public KotlinxVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: kotlinx.coroutines (1.6.4)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getCoroutines() { return getVersion("kotlinx.coroutines"); }

            /**
             * Returns the version associated to this alias: kotlinx.datetime (0.4.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getDatetime() { return getVersion("kotlinx.datetime"); }

            /**
             * Returns the version associated to this alias: kotlinx.serialization (1.4.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getSerialization() { return getVersion("kotlinx.serialization"); }

    }

    public static class RetrofitVersionAccessors extends VersionFactory  implements VersionNotationSupplier {

        private final RetrofitKotlinxVersionAccessors vaccForRetrofitKotlinxVersionAccessors = new RetrofitKotlinxVersionAccessors(providers, config);
        public RetrofitVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the version associated to this alias: retrofit (2.9.0)
         * If the version is a rich version and that its not expressible as a
         * single version string, then an empty string is returned.
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> asProvider() { return getVersion("retrofit"); }

        /**
         * Returns the group of versions at versions.retrofit.kotlinx
         */
        public RetrofitKotlinxVersionAccessors getKotlinx() { return vaccForRetrofitKotlinxVersionAccessors; }

    }

    public static class RetrofitKotlinxVersionAccessors extends VersionFactory  {

        private final RetrofitKotlinxSerializationVersionAccessors vaccForRetrofitKotlinxSerializationVersionAccessors = new RetrofitKotlinxSerializationVersionAccessors(providers, config);
        public RetrofitKotlinxVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.retrofit.kotlinx.serialization
         */
        public RetrofitKotlinxSerializationVersionAccessors getSerialization() { return vaccForRetrofitKotlinxSerializationVersionAccessors; }

    }

    public static class RetrofitKotlinxSerializationVersionAccessors extends VersionFactory  {

        public RetrofitKotlinxSerializationVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: retrofit.kotlinx.serialization.converter (0.8.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getConverter() { return getVersion("retrofit.kotlinx.serialization.converter"); }

    }

    public static class TwitterVersionAccessors extends VersionFactory  {

        private final TwitterComposeVersionAccessors vaccForTwitterComposeVersionAccessors = new TwitterComposeVersionAccessors(providers, config);
        public TwitterVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.twitter.compose
         */
        public TwitterComposeVersionAccessors getCompose() { return vaccForTwitterComposeVersionAccessors; }

    }

    public static class TwitterComposeVersionAccessors extends VersionFactory  {

        public TwitterComposeVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: twitter.compose.rules (0.0.26)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getRules() { return getVersion("twitter.compose.rules"); }

    }

    public static class BundleAccessors extends BundleFactory {
        private final AndroidxBundleAccessors baccForAndroidxBundleAccessors = new AndroidxBundleAccessors(providers, config);

        public BundleAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a dependency bundle provider for retrofit which is an aggregate for the following dependencies:
             * <ul>
             *    <li>com.squareup.okhttp3:okhttp</li>
             *    <li>com.squareup.retrofit2:retrofit</li>
             *    <li>com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter</li>
             * </ul>
             * This bundle was declared in catalog libs.versions.toml
             */
            public Provider<ExternalModuleDependencyBundle> getRetrofit() { return createBundle("retrofit"); }

        /**
         * Returns the group of bundles at bundles.androidx
         */
        public AndroidxBundleAccessors getAndroidx() { return baccForAndroidxBundleAccessors; }

    }

    public static class AndroidxBundleAccessors extends BundleFactory {

        public AndroidxBundleAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a dependency bundle provider for androidx.benchmark which is an aggregate for the following dependencies:
             * <ul>
             *    <li>androidx.test.ext:junit</li>
             *    <li>androidx.test.espresso:espresso-core</li>
             *    <li>androidx.test.uiautomator:uiautomator</li>
             *    <li>androidx.benchmark:benchmark-macro-junit4</li>
             * </ul>
             * This bundle was declared in catalog libs.versions.toml
             */
            public Provider<ExternalModuleDependencyBundle> getBenchmark() { return createBundle("androidx.benchmark"); }

            /**
             * Creates a dependency bundle provider for androidx.compose which is an aggregate for the following dependencies:
             * <ul>
             *    <li>androidx.compose.ui:ui</li>
             *    <li>androidx.compose.material3:material3</li>
             *    <li>androidx.compose.ui:ui-tooling-preview</li>
             *    <li>androidx.compose.ui:ui-util</li>
             * </ul>
             * This bundle was declared in catalog libs.versions.toml
             */
            public Provider<ExternalModuleDependencyBundle> getCompose() { return createBundle("androidx.compose"); }

            /**
             * Creates a dependency bundle provider for androidx.room which is an aggregate for the following dependencies:
             * <ul>
             *    <li>androidx.room:room-runtime</li>
             *    <li>androidx.room:room-ktx</li>
             *    <li>androidx.room:room-paging</li>
             * </ul>
             * This bundle was declared in catalog libs.versions.toml
             */
            public Provider<ExternalModuleDependencyBundle> getRoom() { return createBundle("androidx.room"); }

    }

    public static class PluginAccessors extends PluginFactory {
        private final AndroidPluginAccessors baccForAndroidPluginAccessors = new AndroidPluginAccessors(providers, config);
        private final DaggerPluginAccessors baccForDaggerPluginAccessors = new DaggerPluginAccessors(providers, config);
        private final KotlinPluginAccessors baccForKotlinPluginAccessors = new KotlinPluginAccessors(providers, config);

        public PluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a plugin provider for detekt to the plugin id 'io.gitlab.arturbosch.detekt'
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getDetekt() { return createPlugin("detekt"); }

            /**
             * Creates a plugin provider for ksp to the plugin id 'com.google.devtools.ksp'
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getKsp() { return createPlugin("ksp"); }

            /**
             * Creates a plugin provider for spotless to the plugin id 'com.diffplug.spotless'
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getSpotless() { return createPlugin("spotless"); }

        /**
         * Returns the group of bundles at plugins.android
         */
        public AndroidPluginAccessors getAndroid() { return baccForAndroidPluginAccessors; }

        /**
         * Returns the group of bundles at plugins.dagger
         */
        public DaggerPluginAccessors getDagger() { return baccForDaggerPluginAccessors; }

        /**
         * Returns the group of bundles at plugins.kotlin
         */
        public KotlinPluginAccessors getKotlin() { return baccForKotlinPluginAccessors; }

    }

    public static class AndroidPluginAccessors extends PluginFactory {

        public AndroidPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a plugin provider for android.application to the plugin id 'com.android.application'
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getApplication() { return createPlugin("android.application"); }

            /**
             * Creates a plugin provider for android.library to the plugin id 'com.android.library'
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getLibrary() { return createPlugin("android.library"); }

            /**
             * Creates a plugin provider for android.test to the plugin id 'com.android.test'
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getTest() { return createPlugin("android.test"); }

    }

    public static class DaggerPluginAccessors extends PluginFactory {
        private final DaggerHiltPluginAccessors baccForDaggerHiltPluginAccessors = new DaggerHiltPluginAccessors(providers, config);

        public DaggerPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of bundles at plugins.dagger.hilt
         */
        public DaggerHiltPluginAccessors getHilt() { return baccForDaggerHiltPluginAccessors; }

    }

    public static class DaggerHiltPluginAccessors extends PluginFactory {

        public DaggerHiltPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a plugin provider for dagger.hilt.android to the plugin id 'com.google.dagger.hilt.android'
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getAndroid() { return createPlugin("dagger.hilt.android"); }

    }

    public static class KotlinPluginAccessors extends PluginFactory {

        public KotlinPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a plugin provider for kotlin.android to the plugin id 'org.jetbrains.kotlin.android'
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getAndroid() { return createPlugin("kotlin.android"); }

            /**
             * Creates a plugin provider for kotlin.jvm to the plugin id 'org.jetbrains.kotlin.jvm'
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getJvm() { return createPlugin("kotlin.jvm"); }

            /**
             * Creates a plugin provider for kotlin.kapt to the plugin id 'org.jetbrains.kotlin.kapt'
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getKapt() { return createPlugin("kotlin.kapt"); }

            /**
             * Creates a plugin provider for kotlin.serialization to the plugin id 'org.jetbrains.kotlin.plugin.serialization'
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getSerialization() { return createPlugin("kotlin.serialization"); }

    }

}
